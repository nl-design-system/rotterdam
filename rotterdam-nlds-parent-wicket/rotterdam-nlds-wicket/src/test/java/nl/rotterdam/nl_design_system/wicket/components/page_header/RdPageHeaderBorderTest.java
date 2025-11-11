package nl.rotterdam.nl_design_system.wicket.components.page_header;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdPageHeaderBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var pageHeader = new RdPageHeaderBorder("pageHeader");
        pageHeader.setMarkup(Markup.of("<header wicket:id='pageHeader'>Header contents</header>"));

        // language=HTML
        String expectedHtmlFragment = """
            <header class="utrecht-page-header"><div class="utrecht-page-header__content">Header contents</div></header>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(pageHeader).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}