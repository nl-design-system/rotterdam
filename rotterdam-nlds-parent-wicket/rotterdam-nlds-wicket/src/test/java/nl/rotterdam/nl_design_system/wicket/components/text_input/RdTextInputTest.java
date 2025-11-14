package nl.rotterdam.nl_design_system.wicket.components.text_input;

import static nl.rotterdam.nl_design_system.wicket.components.text_input.RdTextInputCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.components.test_common.CssClassNamesAssertions.assertHasCss;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

class RdTextInputTest extends NldsWicketTestCase {

    @Test
    void renderMinimal() {
        Component firstNameInput = new RdTextInput<>("firstName", () -> "Carola")
            .setMarkup(Markup.of("<input wicket:id='firstName'/>"))
            .setMarkupId("firstName");

        // language=HTML
        String expectedHtmlFragment = """
            <input value="Carola"
              name="firstName"
              id="firstName"
              class="utrecht-textbox utrecht-textbox--html-input">
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(firstNameInput).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void renderInvalid() {
        Component firstNameInput = new RdTextInput<>("firstName", () -> "Carola")
            .setMarkup(Markup.of("<input wicket:id='firstName'/>"))
            .setMarkupId("firstName");

        firstNameInput.error("We moeten weten hoe je heet");

        // language=HTML
        String actualHtmlFragment = ComponentRenderer.renderComponent(firstNameInput).toString();

        TagTester fieldTag = TagTester.createTagByName(actualHtmlFragment, "input");

        assertHasCss(fieldTag, INVALID);
    }
}
