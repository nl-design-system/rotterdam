package nl.rotterdam.nl_design_system.wicket.components.page_layout;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdPageLayoutBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var pageLayout = new RdPageLayoutBorder("pageLayout");
        pageLayout.setMarkup(Markup.of("<div wicket:id='pageLayout'>Layout contents</div>"));

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-page-layout">Layout contents</div>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(pageLayout).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}