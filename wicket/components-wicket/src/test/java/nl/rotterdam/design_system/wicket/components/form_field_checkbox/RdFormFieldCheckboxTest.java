package nl.rotterdam.design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;


class RdFormFieldCheckboxTest extends NldsWicketTestCase {

    @Test
    void shouldRenderCorrectHTMLForCheckboxWithLabel() {

        // from https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field-checkbox--docs#label
        // with minimal changes with Wicket:
        // - attribute ordening
        // - added id attributes; Wicket ajax needs them
        // - set input name the way Wicket needs them.
        // language=HTML
        var expectedHtmlFragment = """ 
        <div id="utrecht-checkbox-field" class="utrecht-form-field utrecht-form-field--checkbox">
          <p class="utrecht-form-field__label utrecht-form-field__label--checkbox">
            <label
              for="checkbox-sample"
              class="utrecht-form-label utrecht-form-label--checkbox"
            >
              <input
                type="checkbox"
                name="static:component:label-container:label:checkbox"
                id="checkbox-sample"
                class="utrecht-form-field__input utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom"
              />
              Ik ga akkoord met de algemene voorwaarden
            </label>
          </p>
        </div>""";


        RdFormFieldCheckbox component = new RdFormFieldCheckbox(
            "component",
            Model.of(false),
            Model.of("Ik ga akkoord met de algemene voorwaarden")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyUtrechtFormFieldContract(component, actualHtmlFragment);

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void shouldRenderCorrectHTMLForCheckboxWithLabelAndDescriptionAndError() {

        // from https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field-checkbox--docs#invalid
        // with minimal changes with Wicket:
        // - attribute ordening
        // - added id attributes; Wicket ajax needs them
        // - set input name the way Wicket needs them.
        // language=HTML
        var expectedHtmlFragment = """ 

            <div id="utrecht-checkbox-field" class="utrecht-form-field--invalid utrecht-form-field utrecht-form-field--checkbox">
                <p class="utrecht-form-field__label utrecht-form-field__label--checkbox">
                  <label
                    for="checkbox-sample"
                    class="utrecht-form-label utrecht-form-label--checkbox"
                  >
                    <input
                      type="checkbox"
                      name="static:component:label-container:label:checkbox"
                      id="checkbox-sample"
                      aria-describedby="description-label error-message-label"
                      class="utrecht-form-field__input utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom utrecht-checkbox--invalid"
                      aria-required="true"
                      aria-invalid="true"
                    />
                    Ik ga akkoord met de algemene voorwaarden
                  </label>
                </p>
                <div
                  id="description-label"
                  class="utrecht-form-field-description utrecht-form-field__description"
                >
                  U kunt ons echt vertrouwen!
                </div>
                <div
                  id="error-message-label"
                  class="utrecht-form-field-error-message utrecht-form-field__error-message"
                >
                  U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.
                </div>
              </div>;""";


        RdFormFieldCheckbox component = new RdFormFieldCheckbox(
            "component",
            Model.of(false),
            Model.of("Ik ga akkoord met de algemene voorwaarden"),
            Model.of("U kunt ons echt vertrouwen!")
        );
        component.setRequired(true);
        component.getControl().error("U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.");

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyUtrechtFormFieldContract(component, actualHtmlFragment);

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    private void setSubjectUnderTestIds(RdFormFieldCheckbox component) {
        component.setMarkupId("utrecht-checkbox-field");
        component.getControl().setMarkupId("checkbox-sample");
        component.getDescriptionComponent().setMarkupId("description-label");
        component.getErrorMessageComponent().setMarkupId("error-message-label");
    }

}