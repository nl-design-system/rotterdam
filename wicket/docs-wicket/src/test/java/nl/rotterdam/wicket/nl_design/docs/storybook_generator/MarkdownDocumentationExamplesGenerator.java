package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.junit.platform.commons.support.ModifierSupport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nl.rotterdam.wicket.nl_design.docs.ModuleRootResolver.resolveModuleRootPath;

public class MarkdownDocumentationExamplesGenerator {

    private final File exampleJavaFile;
    private final File markdownReadmeFile;
    private final File markdownStorybookFile;
    private final Panel headingPanel;
    private final String componentName;
    private final String componentTitle;
    private final HtmlDocumentationExtractor documentationExtractor;
    private final String gitHubExamplePath;
    private final String gitHubComponentPath;

    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> examplePanelClass,
        String componentName,
        String componentTitle
    ) {
        this(examplePanelClass, componentName, componentTitle, null);
    }

    public MarkdownDocumentationExamplesGenerator(
        Class<? extends Panel> examplePanelClass,
        String componentName,
        String componentTitle,
        String renderedHtml
    ) {
        this.componentName = componentName;
        this.componentTitle = componentTitle;

        String moduleRootPath = resolveModuleRootPath(GenerateMarkdownAndStorybookExamples.class).getAbsolutePath();

        String relativePathInDocsWicketFromModuleRoot =
            "/src/main/java/" + examplePanelClass.getPackageName().replace(".", "/") + "/";

        String basePathInDocs = moduleRootPath + relativePathInDocsWicketFromModuleRoot;

        String exampleFilenameWithoutExtension = basePathInDocs + examplePanelClass.getSimpleName();

        exampleJavaFile = new File(exampleFilenameWithoutExtension + ".java");
        documentationExtractor = renderedHtml != null
            ? new HtmlDocumentationExtractor(renderedHtml)
            : new HtmlDocumentationExtractor(new File(exampleFilenameWithoutExtension + ".html").toPath());

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

    private static String extractJavaCode(MethodDeclaration declaration) {
        return declaration.getBody()
            .map(BlockStmt::getStatements)
            .map((it) -> it.stream()
                .map(Object::toString)
                .map((statementText) -> {
                    String statementTextWithReplacedReturn;
                    if (statementText.matches("return [a-zA-Z]+;")) {
                        statementTextWithReplacedReturn = null;
                    } else if (statementText.startsWith("return ")) {
                        statementTextWithReplacedReturn = declaration.getType().toString() + " component = " + statementText.substring("return ".length());
                    } else {
                        statementTextWithReplacedReturn = statementText;
                    }
                    return statementTextWithReplacedReturn;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.joining(System.lineSeparator())))
            .orElse("");
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
            componentTitle
        );

        Files.write(markdownStorybookFile.toPath(), content.getBytes());
    }

    private void writeWicketComponentsReadme(List<WicketComponentExample> results) throws IOException {
        List<String> lines = new ArrayList<>(
            List.of(
                "<!-- @license CC0-1.0 -->",
                "",
                "# " + componentTitle + " component voor Apache Wicket",
                "",
                convertToMarkdown(documentationExtractor.extractHeader()),
                "",
                "[Broncode van dit voorbeeld](" + gitHubExamplePath + ")",
                "",
                "[Broncode van het component](" + gitHubComponentPath + ")"
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
        System.out.println("Written to file: " + markdownReadmeFile.getAbsolutePath());
    }

    private String convertToMarkdown(String html) {
        return FlexmarkHtmlConverter.builder().build().convert(html);
    }

    private String wrapInDemoJavaPanelWithOnInitialize(String statement) {

        return Arrays.stream(statement.split(System.lineSeparator()))
            .collect(Collectors.joining(System.lineSeparator()));
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
