package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtrechtFormFieldTextboxTest extends NldsWicketTestCase {


    @Test
    void rendersNaamWithLabelAndDescriptionAsDefinedInReferenceGuide() {

        // language=HTML
        var htmlFromReference = """
            <div id="utrecht-textbox-field" class="utrecht-form-field utrecht-form-field--text">
                    <div class="utrecht-form-field__label">
                      <label
                        for="input-text"
                        class="utrecht-form-label"
                      >
                        Naam
                      </label>
                    </div>
                    <div class="utrecht-form-field__description">Voornaam en achternaam.</div>
                    <div class="utrecht-form-field__input">
                      <input
                        id="input-text"
                        type="text"
                        class="utrecht-textbox utrecht-textbox--html-input"
                        dir="auto"
                      />
                    </div>
                  </div>""";

        var component = new UtrechtFormFieldTextbox<>(
            "component",
            Model.of(""),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam."),
            Model.of(""));

        setSubjectUnderTestIds(component);

        String actualRenderedMarkup = renderComponentInTestPanel(component);

        assertEquals(formatTidy(htmlFromReference), formatTidy(actualRenderedMarkup));

    }

    private void setSubjectUnderTestIds(UtrechtFormFieldTextbox<?> component) {
        component.setMarkupId("utrecht-textbox-field");
        component.getTextField().setMarkupId("input-text");
        component.getDescriptionLabel().setMarkupId("description-label");
        component.getErrorMessageLabel().setMarkupId("error-message-label");
    }

}