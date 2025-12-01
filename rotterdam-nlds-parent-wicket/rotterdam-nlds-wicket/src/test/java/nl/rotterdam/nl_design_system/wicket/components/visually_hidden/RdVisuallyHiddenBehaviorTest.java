package nl.rotterdam.nl_design_system.wicket.components.visually_hidden;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class RdVisuallyHiddenBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(RdVisuallyHiddenBehavior.CSS_HEADER_ITEM);
    }

    @Test
    void render() {
        var checkbox = new WebMarkupContainer("element")
            .setMarkup(Markup.of("<div wicket:id='element'></div>"))
            .add(RdVisuallyHiddenBehavior.INSTANCE);

        // language=HTML
        String expectedHtmlFragment = """
            <div class="ams-visually-hidden"></div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkbox).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
