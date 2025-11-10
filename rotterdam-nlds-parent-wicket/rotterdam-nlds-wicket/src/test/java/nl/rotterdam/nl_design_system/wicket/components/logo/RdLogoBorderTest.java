package nl.rotterdam.nl_design_system.wicket.components.logo;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdLogoBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var logo = new RdLogoBorder("logo");
        logo.setMarkup(Markup.of("<div wicket:id='logo'>Logo contents</div>"));

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-logo">Logo contents</div>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(logo).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}