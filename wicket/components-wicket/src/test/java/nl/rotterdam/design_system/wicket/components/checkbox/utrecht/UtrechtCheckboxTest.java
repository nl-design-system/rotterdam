package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtrechtCheckboxTest extends NldsWicketTestCase {

    @Test
    void renders() {

        Component checkbox = new UtrechtCheckbox("checkbox", () -> false)
            .setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'/>"))
            .setMarkupId("checkbox");

        // language=HTML
        String expectedOutput = """
            <input
                type="checkbox"
                name="checkbox"
                id="checkbox"
                class="utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom"
            />
            """;

        String actualOutput = ComponentRenderer.renderComponent(checkbox).toString();

        assertEquals(formatTidy(expectedOutput), formatTidy(actualOutput));

    }
}