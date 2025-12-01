package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

class RdIconAjaxButtonBorderTest extends NldsWicketTestCase {

    @Test
    void renderWithoutSize() {
        var button = new RdIconAjaxButtonBorder("button", Model.of("Label")) {
        }
            .setMarkup(Markup.of("<button wicket:id='button'>Icon</button>"));

        // language=HTML
        String expectedHtmlFragment = """
            <button name="button" id="button1" class="ams-icon-button"><span class="ams-visually-hidden">Label</span>Icon</button>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(button).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
