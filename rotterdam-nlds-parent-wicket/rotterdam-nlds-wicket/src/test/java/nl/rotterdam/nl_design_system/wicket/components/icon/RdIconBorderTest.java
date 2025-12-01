package nl.rotterdam.nl_design_system.wicket.components.icon;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdIconBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var icon = new RdIconBorder("icon");
        icon.setMarkup(Markup.of("<span wicket:id='icon'>Icon contents</span>"));

        // language=HTML
        String expectedHtmlFragment = """
            
            <span class="utrecht-icon"> Icon contents </span>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(icon).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}