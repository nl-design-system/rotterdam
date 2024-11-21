package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.string.Strings;
import org.junit.platform.commons.support.ModifierSupport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static nl.rotterdam.wicket.nl_design.docs.ModuleRootResolver.resolveModuleRootPath;

public class MarkdownDocumentationExamplesGenerator {

    private final File javaFile;
    private final File markdownReadmeFile;
    private final File markdownStorybookFile;
    private final Panel headingPanel;
    private final String componentName;
    private final String componentNameCapitalized;
    private final HtmlDocumentationExtractor documentationExtractor;

    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> panelClazz,
        String componentName
    ) {
        this.componentName = componentName;
        this.componentNameCapitalized = Strings.capitalize(componentName);

        String moduleRootPath = resolveModuleRootPath(
            GenerateMarkdownAndStorybookExamples.class
        ).getAbsolutePath();
        String basePathInDocs =
            moduleRootPath +
                "/src/main/java/" +
                panelClazz.getPackageName().replace(".", "/") +
                "/";
        String basePathInWicketComponent =
            moduleRootPath +
                "/../components-wicket/src/main/java/nl/rotterdam/nl_design/wicket/components/" +
                this.componentName +
                "/";
        String nameWithoutExtension =
            basePathInDocs + panelClazz.getSimpleName();

        javaFile = new File(nameWithoutExtension + ".java");
        documentationExtractor = new HtmlDocumentationExtractor(
            new File(nameWithoutExtension + ".html").toPath()
        );

        markdownReadmeFile = new File(basePathInWicketComponent + "README.md");
        markdownStorybookFile = new File(
            moduleRootPath +
                "/../../packages/storybook/src/documentation/wicket-" +
                componentName +
                ".mdx"
        );

        try {
            headingPanel = panelClazz
                .getConstructor(String.class)
                .newInstance("panelId");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeSemicolon(String statement) {
        if (!statement.endsWith(";")) {
            return statement;
        }

        return statement.substring(0, statement.length() - 1);
    }

    private static String extractJavaCode(MethodDeclaration x) {
        String temp = x
            .getBody()
            .orElseThrow()
            .toString()
            .replaceFirst("return", "")
            .replaceFirst("\\{", "");
        temp = temp.substring(0, temp.lastIndexOf("}"));
        return temp.trim();
    }

    public void generate() {
        try {
            generateWithCheckedExceptions();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void generateWithCheckedExceptions() throws Exception {
        List<WicketComponentExample> results = collectExamples();

        writeResultsToFiles(results);
    }

    private List<WicketComponentExample> collectExamples()
        throws Exception {
        CompilationUnit compilationUnit = new JavaParser()
            .parse(javaFile)
            .getResult()
            .orElseThrow();

        List<MethodDeclaration> exampleComponentMethods =
            compilationUnit.findAll(MethodDeclaration.class, m ->
                m
                    .getAnnotationByName(ComponentExample.class.getSimpleName())
                    .isPresent()
            );

        exampleComponentMethods.sort(
            Comparator.comparing(declaration ->
                declaration.getName().getIdentifier()
            )
        );

        return exampleComponentMethods
            .stream()
            .map(method -> {
                try {
                    return generateMethodUnchecked(method, headingPanel);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .toList();
    }

    private void writeResultsToFiles(List<WicketComponentExample> results)
        throws IOException {
        writeWicketComponentsReadme(results);

        writeStoryBookFile();
    }

    private void writeStoryBookFile() throws IOException {
        String content = String.format(
            """
                import { Markdown, Meta } from "@storybook/blocks";
                import markdown from "../../../../wicket/components-wicket/src/main/java/nl/rotterdam/nl_design/wicket/components/%s/README.md?raw";
                
                <Meta title="Apache Wicket/%s" />
                
                <Markdown>{markdown}</Markdown>
                """,
            componentName,
            Strings.capitalize(componentName)
        );

        Files.write(markdownStorybookFile.toPath(), content.getBytes());
    }

    private void writeWicketComponentsReadme(
        List<WicketComponentExample> results
    ) throws IOException {
        List<String> lines = new ArrayList<>(
            List.of(
                "# " + componentNameCapitalized + " component voor Apache Wicket",
                "",
                "",
                documentationExtractor.extractHeader(),
                "",
                "Hieronder volgen verschillende voorbeelden van het gebruik van het component in Apache Wicket."
            )
        );

        IntStream.range(0, results.size()).forEach(i -> {
            WicketComponentExample example = results.get(i);
            lines.addAll(
                List.of(
                    "",
                    "## " + example.htmlSnippet().headerHtml(),
                    "")
            );

            if (example.htmlSnippet().documentationHtml() != null) {
                lines.addAll(
                    List.of(
                        example.htmlSnippet().documentationHtml(),
                        ""
                    )
                );
            }

            lines.addAll(
                List.of(
                    "```html",
                    example.htmlSnippet().codeHTML(),
                    "```",
                    "",
                    "```java",
                    wrapInDemoJavaPanelWithOnInitialize(example.javaCode()),
                    "```"
                )
            );
        });

        Files.write(markdownReadmeFile.toPath(), lines);
    }

    private String wrapInDemoJavaPanelWithOnInitialize(String statement) {
        return String.format(
            """
                public class NlDesignSystemWicketDemoPanel extends Panel {
                
                    public NlDesignSystemWicketDemoPanel(String id) {
                        super(id);
                    }
                
                    @Override
                    protected void onInitialize() {
                        super.onInitialize();
                        add(%s);
                    }
                }""",
            removeSemicolon(statement)
        );
    }

    private WicketComponentExample generateMethodUnchecked(
        MethodDeclaration methodDeclaration,
        Panel headingPanel
    ) throws Exception {
        String wicketId = getWicketId(headingPanel, methodDeclaration);

        return new WicketComponentExample(
            extractJavaCode(methodDeclaration),
            documentationExtractor.extractExample(wicketId),
            wicketId
        );
    }

    private String getWicketId(Panel panel, MethodDeclaration declaration)
        throws Exception {
        Method method = panel
            .getClass()
            .getDeclaredMethod(declaration.getName().asString());

        method.setAccessible(true);

        Object host = ModifierSupport.isStatic(method) ? null : panel;

        Component result = (Component) method.invoke(host);

        return result.getId();
    }

}

record WicketComponentExample(
    String javaCode,
    WicketHtmlExampleSnippet htmlSnippet,
    String wicketId
) {

}
