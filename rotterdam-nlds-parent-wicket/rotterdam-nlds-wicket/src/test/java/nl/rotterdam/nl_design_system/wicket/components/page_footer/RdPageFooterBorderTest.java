package nl.rotterdam.nl_design_system.wicket.components.page_footer;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdPageFooterBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var pageFooter = new RdPageFooterBorder("pageFooter");
        pageFooter.setMarkup(Markup.of("<footer wicket:id='pageFooter'>Footer contents</footer>"));

        // language=HTML
        String expectedHtmlFragment = """
            <footer class="utrecht-page-footer"><div class="utrecht-page-footer__content">Footer contents</div></footer>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(pageFooter).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}