package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.test_util.CssClassNamesAssertions.assertHasCss;
import static nl.rotterdam.nl_design_system.wicket.test_util.FormFieldAssertions.verifyFormFieldContract;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

class RdFormFieldTextAreaTest extends NldsWicketTestCase {

    @Test
    void rendersOpmerkingWithLabelAndDescriptionAsDefinedInReferenceGuide() {
        // From https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs#relevante-wcag-regels
        // with minimal changes with Wicket:
        // - attribute ordering
        // - added id attributes; Wicket ajax needs them
        // - set input name the way Wicket needs them.
        // - aria-describedby added, it was missing, but I think it is needed.
        // language=HTML
        var expectedHtmlFragment = """
            <div id="form-field-opmerking" class="utrecht-form-field utrecht-form-field--text">
              <div class="utrecht-form-field__label">
                <label
                  for="textarea-opmerking"
                  class="utrecht-form-label"
                >Opmerking</label>
              </div>
              <div id="description-label" class="utrecht-form-field-description utrecht-form-field__description">Voer hier eventuele opmerkingen in.</div>
              <div class="utrecht-form-field__input">
                <textarea
                  name="static:component:input-container:control"
                  id="textarea-opmerking"
                  aria-describedby="description-label"
                  class="utrecht-textarea"
                ></textarea>
              </div>
            </div>""";

        var component = new RdFormFieldTextArea<>(
            "component",
            Model.of(""),
            Model.of("Opmerking"),
            Model.of("Voer hier eventuele opmerkingen in.")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualHtmlFragment);
        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRenderingAddsCorrectCssClasses() {
        var component = new RdFormFieldTextArea<>(
            "component",
            Model.of("Tekst met ❤️ emoji"),
            Model.of("Opmerking"),
            Model.of("Voer hier eventuele opmerkingen in.")
        );

        setSubjectUnderTestIds(component);

        component.getTextArea().error("Verwijder de emoji-tekens uit de opmerking");

        String actualRenderedMarkup = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualRenderedMarkup);

        TagTester fieldTag = TagTester.createTagByAttribute(actualRenderedMarkup, "id", "form-field-opmerking");

        assertHasCss(fieldTag, INVALID);
    }

    private void setSubjectUnderTestIds(RdFormFieldTextArea<?> component) {
        component.setMarkupId("form-field-opmerking");
        component.getTextArea().setMarkupId("textarea-opmerking");
        component.getDescriptionComponent().setMarkupId("description-label");
        component.getErrorMessageComponent().setMarkupId("error-message-label");
    }
}
