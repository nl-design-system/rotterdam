package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.string.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.platform.commons.support.ModifierSupport;

import java.io.File;
import java.io.FileNotFoundException;
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
    private final File htmlFile;
    private final File markdownReadmeFile;
    private final File markdownStorybookFile;
    private final Panel headingPanel;
    private final String componentName;

    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> panelClazz,
        String componentName
    ) {
        this.componentName = componentName;

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
        htmlFile = new File(nameWithoutExtension + ".html");
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
        throws FileNotFoundException {
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
            Strings.capitalize(componentName) // TODO: first char to upper
        );

        Files.write(markdownStorybookFile.toPath(), content.getBytes());
    }

    private void writeWicketComponentsReadme(
        List<WicketComponentExample> results
    ) throws IOException {
        List<String> lines = new ArrayList<>(
            List.of(
                "# " + componentName + " component voor Apache Wicket",
                "",
                "Gebruik de component als volgt:"
            )
        );

        IntStream.range(0, results.size()).forEach(i -> {
            WicketComponentExample example = results.get(i);
            lines.addAll(
                List.of(
                    "",
                    "Voorbeeld " + (i + 1),
                    "",
                    "```html",
                    example.htmlCode(),
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
                class NlDesignSystemWicketDemoPanel extends Panel {
                
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
            extractMarkup(wicketId),
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

    private String extractMarkup(String wicketId) throws IOException {
        String htmlContent = Files.readString(htmlFile.toPath());

        // Parse the HTML content with Jsoup
        Document document = Jsoup.parse(htmlContent);

        // Select the element with wicket:id="utrechtLabel2"
        Element element = document.selectFirst(
            "[wicket:enclosure=" + wicketId + "]"
        );

        if (element == null) {
            element = document.selectFirst("[wicket:id=" + wicketId + "]");
        }

        if (element == null) {
            throw new IllegalArgumentException(
                "No wicket markup found for id: " + wicketId
            );
            // Output the full HTML of the selected element
        }

        return element.outerHtml();
    }
}

record WicketComponentExample(
    String javaCode,
    String htmlCode,
    String wicketId
) {
}
