package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Charsets;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
        Element element = document.selectFirst("[data-testid=" + wicketId + "]");

        checkNotNull(element, "No element found for: " + wicketId);

        return new WicketHtmlExampleSnippet(
            checkNotNull(element.selectFirst("h2"), wicketId + "must have header").html(),
            Optional.ofNullable(element.selectFirst("h2 + div")).map(Element::html).orElse(null),
            checkNotNull(element.selectFirst("template"), wicketId + "must have code").html()
        );
    }

    public String extractHeader() {
        return checkNotNull(document.selectFirst("h1 + div")).html();
    }
}
