package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtrechtFormFieldTextboxTest extends NldsWicketTestCase {

    @Test
    void rendersNaamWithLabelAndDescriptionAsDefinedInReferenceGuide() {

        // From https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs#relevante-wcag-regels
        // with minimal changes with Wicket:
        // - attribute ordening
        // - added id attributes; Wicket ajax needs them
        // - set input name the way Wicket needs them.
        // - aria-describedby added, it was missing but I think it is needed.
        // language=HTML
        var htmlFromReference = """
            <div id="utrecht-textbox-field" class="utrecht-form-field utrecht-form-field--text">
                    <div class="utrecht-form-field__label">
                      <label
                        for="input-text"
                        class="utrecht-form-label"
                      >Naam</label>
                    </div>
                    <div id="description-label" class="utrecht-form-field-description utrecht-form-field__description">Voornaam en achternaam.</div>
                    <div class="utrecht-form-field__input">
                      <input
                        type="text"
                        value=""
                        name="static:component:control"
                        id="input-text"
                        class="utrecht-textbox utrecht-textbox--html-input"
                        aria-describedby="description-label"
                      />
                    </div>
                  </div>""";

        var component = new UtrechtFormFieldTextbox<>(
            "component",
            Model.of(""),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam.")
        );

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