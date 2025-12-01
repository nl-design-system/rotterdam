package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.test_util.CssClassNamesAssertions.assertHasCss;
import static nl.rotterdam.nl_design_system.wicket.test_util.FormFieldAssertions.verifyFormFieldContract;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

class RdFormFieldTextInputTest extends NldsWicketTestCase {

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
            <div id="form-field-name" class="utrecht-form-field utrecht-form-field--text">
              <div class="utrecht-form-field__label">
                <label
                  class="utrecht-form-label"
                  for="input-text"
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

        var component = new RdFormFieldTextInput<>(
            "component",
            Model.of(""),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam.")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualHtmlFragment);
        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRenderingAddsCorrectCssClasses() {
        var component = new RdFormFieldTextInput<>(
            "component",
            Model.of("I ❤️ Martine"),
            Model.of("Naam"),
            Model.of("Voornaam en achternaam.")
        );

        setSubjectUnderTestIds(component);

        component.getTextField().error("Verwijder de emoji-tekens uit de naam");

        String actualRenderedMarkup = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualRenderedMarkup);

        TagTester fieldTag = TagTester.createTagByAttribute(actualRenderedMarkup, "id", "form-field-name");

        assertHasCss(fieldTag, INVALID);
    }

    private void setSubjectUnderTestIds(RdFormFieldTextInput<?> component) {
        component.setMarkupId("form-field-name");
        component.getTextField().setMarkupId("input-text");
        component.getDescriptionComponent().setMarkupId("description-label");
        component.getErrorMessageComponent().setMarkupId("error-message-label");
    }
}
