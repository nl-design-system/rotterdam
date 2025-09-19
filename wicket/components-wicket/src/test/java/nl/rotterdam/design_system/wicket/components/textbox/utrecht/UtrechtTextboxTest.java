package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class UtrechtTextboxTest extends NldsWicketTestCase {

    @Test
    void renderMinimal() {
        Component firstNameInput = new UtrechtTextbox<>("firstName", () -> "Carola")
            .setMarkup(Markup.of("<input wicket:id='firstName'/>"))
            .setMarkupId("firstName");

        // language=HTML
        String expectedHtmlFragment = """
            <input value="Carola"
              name="control"
              id="firstName"
              class="utrecht-textbox utrecht-textbox--html-input">
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(firstNameInput).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}