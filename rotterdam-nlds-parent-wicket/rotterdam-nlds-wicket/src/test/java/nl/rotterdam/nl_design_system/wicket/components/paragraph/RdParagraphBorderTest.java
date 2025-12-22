package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdParagraphBorderTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var paragraph = new RdParagraphBorder("paragraph")
            .setMarkup(Markup.of("<p wicket:id='paragraph'>the text</p>"))
            .setMarkupId("paragraph");

        // language=HTML
        String expectedHtmlFragment = """
            <p id='paragraph' class='nl-paragraph'>the text</p>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(paragraph).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void leadRendersCorrectly() {
        var paragraph = new RdParagraphBorder("paragraph", RdParagraphAppearance.LEAD)
            .setMarkup(Markup.of("<p wicket:id='paragraph'>the text</p>"))
            .setMarkupId("paragraph");

        // language=HTML
        String expectedHtmlFragment = """
            <p id='paragraph' class='nl-paragraph nl-paragraph--lead'>the text</p>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(paragraph).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
