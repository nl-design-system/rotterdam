package nl.rotterdam.design_system.wicket.components.textbox;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.design_system.wicket.components.textbox.NlTextboxCss.INVALID;

class NlTextboxTest extends NldsWicketTestCase {

    @Test
    void renderMinimal() {
        Component firstNameInput = new NlTextbox<>("firstName", () -> "Carola")
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

        Component firstNameInput = new NlTextbox<>("firstName", () -> "Carola")
            .setMarkup(Markup.of("<input wicket:id='firstName'/>"))
            .setMarkupId("firstName");

        firstNameInput.error("We moeten weten hoe je heet");

        // language=HTML
        String actualHtmlFragment = ComponentRenderer.renderComponent(firstNameInput).toString();

        TagTester fieldTag = TagTester.createTagByName(actualHtmlFragment, "input");

        assertHasCss(fieldTag, INVALID);
    }
}