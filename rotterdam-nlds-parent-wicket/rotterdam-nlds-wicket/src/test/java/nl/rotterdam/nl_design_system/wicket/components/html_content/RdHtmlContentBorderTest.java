package nl.rotterdam.nl_design_system.wicket.components.html_content;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdHtmlContentBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var htmlContent = new RdHtmlContentBorder("htmlContent");
        htmlContent.setMarkup(Markup.of("<div wicket:id='htmlContent'>HTML contents</div>"));

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-html">HTML contents</hgroup>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(htmlContent).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}