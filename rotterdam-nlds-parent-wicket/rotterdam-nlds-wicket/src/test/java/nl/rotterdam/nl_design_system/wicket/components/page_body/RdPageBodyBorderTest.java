package nl.rotterdam.nl_design_system.wicket.components.page_body;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdPageBodyBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var pageBody = new RdPageBodyBorder("pageBody");
        pageBody.setMarkup(Markup.of("<div wicket:id='pageBody'>Body contents</div>"));

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-page-body"><div class="utrecht-page-body__content">Body contents</div></div>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(pageBody).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}