package nl.rotterdam.design_system.wicket.components.form_field_textbox;

import nl.rotterdam.design_system.wicket.components.form_field_textbox.NlFormFieldTextbox;
import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss.INVALID;

class NlFormFieldTextboxTest extends NldsWicketTestCase {

    @Test
    void rendersNaamWithLabelAndDescriptionAsDefinedInReferenceGuide() {

        // From https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs#relevante-wcag-regels
        // with minimal changes with Wicket:
        // - attribute ordening
        // - added id attributes; Wicket ajax needs them
        // - set input name the way Wicket needs them.
        // - aria-describedby added, it was missing, but I think it is needed.
        // language=HTML
        var expectedHtmlFragment = """
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
                        value=""
                        name="static:component:input-container:control"
                        id="input-text"
                        aria-describedby="description-label"
                        type="text"
                        class="utrecht-textbox utrecht-textbox--html-input"
                      />
                    </div>
                  </div>""";

        var component = new NlFormFieldTextbox<>(
            "component",
            Model.of(""),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam.")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderFormFieldComponentInTestPanel(component);

        verifyUtrechtFormFieldContract(component, actualHtmlFragment);

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRenderingAddsCorrectCssClasses() {

        var component = new NlFormFieldTextbox<>(
            "component",
            Model.of("I ❤️ Martine"),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam.")
        );

        setSubjectUnderTestIds(component);

        component.getTextField().error("Verwijder de emoji-tekens uit de naam");

        String actualRenderedMarkup = renderFormFieldComponentInTestPanel(component);

        verifyUtrechtFormFieldContract(component, actualRenderedMarkup);

        TagTester fieldTag = TagTester.createTagByAttribute(actualRenderedMarkup, "id", "utrecht-textbox-field");

        assertHasCss(fieldTag, INVALID);
    }

    private void setSubjectUnderTestIds(NlFormFieldTextbox<?> component) {
        component.setMarkupId("utrecht-textbox-field");
        component.getTextField().setMarkupId("input-text");
        component.getDescriptionComponent().setMarkupId("description-label");
        component.getErrorMessageComponent().setMarkupId("error-message-label");
    }

}