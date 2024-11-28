package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

public record WicketHtmlExampleSnippet(
    String headerHtml,
    @Nullable String documentationHtml,
    String codeHTML
) {
    public WicketHtmlExampleSnippet {
        requireNonNull(headerHtml, "headerHtml must not be null");
        requireNonNull(codeHTML, "codeHTML must not be null");
    }
}
