package nl.rotterdam.design_system.wicket.components.checkbox;

import nl.rotterdam.design_system.wicket.components.checkbox.NlCheckbox;
import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class NlCheckboxTest extends NldsWicketTestCase {

    @Test
    void renderMinimal() {

        Component checkbox = new NlCheckbox("checkbox", () -> false)
            .setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'/>"))
            .setMarkupId("checkbox");

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="checkbox"
                name="checkbox"
                id="checkbox"
                class="utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkbox).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }


}