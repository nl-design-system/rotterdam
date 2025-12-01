package nl.rotterdam.nl_design_system.docs.wicket.storybook_generator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;

public class HtmlDocumentationExtractor {

    private final Document document;

    public HtmlDocumentationExtractor(Path path) {
        try {
            document = Jsoup.parse(path, UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HtmlDocumentationExtractor(String renderedHtml) {
        document = Jsoup.parse(renderedHtml);
    }

    public WicketHtmlExampleSnippet extractExample(String wicketId) {
        Element element = document.selectFirst("[data-testid=" + wicketId + "]");

        requireNonNull(
            element,
            () -> "No element found for: " + wicketId + ". Add it inside: <section data-testid=\"" + wicketId + "\">"
        );

        String codeHtml;
        var storybookHtml = element.selectFirst("div[data-nlds-role='storybook-html']");
        if (storybookHtml == null) {
            codeHtml = requireNonNull(element.selectFirst("template"), () -> wicketId + "must have code").html();
        } else {
            // Storybook HTML is needed if the document structure would become invalid if that HTML would actually be
            // present in an example page. So the storybook HTML is escaped to ensure the document remains valid.
            
            codeHtml = Parser.unescapeEntities(storybookHtml.html(), false);
        }
        return new WicketHtmlExampleSnippet(
            requireNonNull(element.selectFirst("h2"), () -> wicketId + "must have header").html(),
            Optional.ofNullable(element.selectFirst("h2 + div")).map(Element::html).orElse(null),
            codeHtml
        );
    }

    public String extractHeader() {
        Element documentationDiv = requireNonNull(document.selectFirst("h1 + div"));
        documentationDiv
            .select("a[href='#']")
            .forEach(otherComponentLink -> {
                var replacementUri =
                    "?path=/docs/apache-wicket-" +
                    otherComponentLink.text().toLowerCase(Locale.ENGLISH).replace(' ', '-') +
                    "--docs";
                Objects.requireNonNull(otherComponentLink.attribute("href")).setValue(replacementUri);
            });
        return documentationDiv.html();
    }
}
