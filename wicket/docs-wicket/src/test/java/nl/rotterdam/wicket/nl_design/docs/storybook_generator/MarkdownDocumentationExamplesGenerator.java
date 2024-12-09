package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
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

    private final File exampleJavaFile;
    private final File markdownReadmeFile;
    private final File markdownStorybookFile;
    private final Panel headingPanel;
    private final String componentName;
    private final String componentNameCapitalized;
    private final HtmlDocumentationExtractor documentationExtractor;
    private final String gitHubExamplePath;
    private final String gitHubComponentPath;

    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> examplePanelClass,
        /*
          When you have a Behavior and a component, put them in the same package.
         */
        Class<? extends Component> componentClass,
        String componentName) {
        this(examplePanelClass, componentClass, componentName, null);
    }
    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> examplePanelClass,
        /*
          When you have a Behavior and a component, put them in the same package.
         */
        Class<? extends Component> componentClass,
        String componentName,
        String renderedHtml) {
        this.componentName = componentName;
        this.componentNameCapitalized = Strings.capitalize(componentName);

        String moduleRootPath = resolveModuleRootPath(GenerateMarkdownAndStorybookExamples.class).getAbsolutePath();

        String relativePathInDocsWicketFromModuleRoot =
            "/src/main/java/" + examplePanelClass.getPackageName().replace(".", "/") + "/";

        String basePathInDocs = moduleRootPath + relativePathInDocsWicketFromModuleRoot;

        String exampleFilenameWithoutExtension = basePathInDocs + examplePanelClass.getSimpleName();

        exampleJavaFile = new File(exampleFilenameWithoutExtension + ".java");
        documentationExtractor =
            renderedHtml != null
                ? new HtmlDocumentationExtractor(renderedHtml)
                : new HtmlDocumentationExtractor(new File(exampleFilenameWithoutExtension + ".html").toPath()
        );

        markdownReadmeFile = new File(moduleRootPath + "/stories/" + componentName + ".md");
        markdownStorybookFile = new File(moduleRootPath + "/stories/" + componentName + ".mdx");

        gitHubComponentPath =
            "https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket/" +
            relativePathInDocsWicketFromModuleRoot;

        gitHubExamplePath =
            "https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket/" +
            relativePathInDocsWicketFromModuleRoot;
        try {
            headingPanel = examplePanelClass.getConstructor(String.class).newInstance("panelId");
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
        String temp = x.getBody().orElseThrow().toString().replaceFirst("return", "").replaceFirst("\\{", "");
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

    private List<WicketComponentExample> collectExamples() throws Exception {
        CompilationUnit compilationUnit = new JavaParser().parse(exampleJavaFile).getResult().orElseThrow();

        List<MethodDeclaration> exampleComponentMethods = compilationUnit.findAll(MethodDeclaration.class, m ->
            m.getAnnotationByName(ComponentExample.class.getSimpleName()).isPresent()
        );

        exampleComponentMethods.sort(Comparator.comparing(declaration -> declaration.getName().getIdentifier()));

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

    private void writeResultsToFiles(List<WicketComponentExample> results) throws IOException {
        writeWicketComponentsReadme(results);

        writeStoryBookFile();
    }

    private void writeStoryBookFile() throws IOException {
        String content = String.format(
            """
            {/* @license CC0-1.0 */}

            import { Markdown, Meta } from "@storybook/blocks";
            import markdown from "./%s.md?raw";

            <Meta title="Apache Wicket/%s" />

            <Markdown>{markdown}</Markdown>
            """,
            componentName,
            Strings.capitalize(componentName)
        );

        Files.write(markdownStorybookFile.toPath(), content.getBytes());
    }

    private void writeWicketComponentsReadme(List<WicketComponentExample> results) throws IOException {
        List<String> lines = new ArrayList<>(
            List.of(
                "<!-- @license CC0-1.0 -->",
                "",
                "# " + componentNameCapitalized + " component voor Apache Wicket",
                "",
                convertToMarkdown(documentationExtractor.extractHeader()),
                "",
                "[Broncode van dit voorbeeld](" + gitHubExamplePath + ")",
                "",
                "[Broncode van de component](" + gitHubComponentPath + ")"
            )
        );

        IntStream.range(0, results.size()).forEach(i -> {
            WicketComponentExample example = results.get(i);
            lines.addAll(List.of("", "## " + example.htmlSnippet().headerHtml(), ""));

            if (example.htmlSnippet().documentationHtml() != null) {
                lines.addAll(List.of(convertToMarkdown(example.htmlSnippet().documentationHtml()), ""));
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

    private String convertToMarkdown(String html) {
        return FlexmarkHtmlConverter.builder().build().convert(html);
    }

    private String wrapInDemoJavaPanelWithOnInitialize(String statement) {
        return String.format(
            """
            public class ExamplePanel extends Panel {

                public ExamplePanel(String id) {
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

    private WicketComponentExample generateMethodUnchecked(MethodDeclaration methodDeclaration, Panel headingPanel)
        throws Exception {
        String wicketId = getWicketId(headingPanel, methodDeclaration);

        return new WicketComponentExample(
            extractJavaCode(methodDeclaration),
            documentationExtractor.extractExample(wicketId),
            wicketId
        );
    }

    private String getWicketId(Panel panel, MethodDeclaration declaration) throws Exception {
        Method method = panel.getClass().getDeclaredMethod(declaration.getName().asString());

        method.setAccessible(true);

        Object host = ModifierSupport.isStatic(method) ? null : panel;

        Component result = (Component) method.invoke(host);

        return result.getId();
    }
}

record WicketComponentExample(String javaCode, WicketHtmlExampleSnippet htmlSnippet, String wicketId) {}
