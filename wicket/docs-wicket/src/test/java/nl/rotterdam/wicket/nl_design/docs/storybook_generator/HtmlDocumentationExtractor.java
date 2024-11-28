package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import com.google.common.base.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class HtmlDocumentationExtractor {

    private final Document document;

    public HtmlDocumentationExtractor(Path path) {
        try {
            document = Jsoup.parse(path, Charsets.UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WicketHtmlExampleSnippet extractExample(String wicketId) {
        Element element = document.selectFirst(
            "[data-example-container-for=" + wicketId + "]"
        );

        checkNotNull(element, "No element found for: " + wicketId);

        return new WicketHtmlExampleSnippet(
            checkNotNull(element.selectFirst(".example-container__header"), wicketId + "mus have header").html(),
            Optional.ofNullable(element.selectFirst(".example-container__documentation")).map(Element::html).orElse(null),
            checkNotNull(element.selectFirst(".example-container__code"), wicketId + "mus have code").html()
        );
    }

    public String extractHeader() {
        return checkNotNull(document.selectFirst("header")).html();
    }
}
