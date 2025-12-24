package nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker;

import static nl.rotterdam.nl_design_system.wicket.test_util.FormFieldAssertions.verifyFormFieldContract;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

class RdFormFieldDatePickerTest extends NldsWicketTestCase {

    @Test
    void rendersDatePickerWithLabelAndDescriptionAsFormField() {
        // language=HTML
        var expectedHtmlFragment = """
            <div id="form-field-appointment" class="utrecht-form-field utrecht-form-field--date-picker">
              <div class="utrecht-form-field__label">
                <label
                  for="control-date"
                  class="utrecht-form-label"
                >Appointment Date</label>
              </div>
              <div id="description-label" class="utrecht-form-field-description utrecht-form-field__description">Select a date and time for your appointment.</div>
              <div id="error-message-label" class="utrecht-form-field__error-message"></div>
              <div class="utrecht-form-field__input">
                <rods-date-picker
                  value="2025-12-31T10:05"
                  name="control"
                  id="control-date"
                  aria-describedby="description-label"
                  class="rods-date-picker"
                ></rods-date-picker>
              </div>
            </div>""";

        var component = new RdFormFieldDatePicker<>(
            "component",
            Model.of("2025-12-31T10:05"),
            Model.of("Appointment Date"),
            Model.of("Select a date and time for your appointment.")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualHtmlFragment);
        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void rendersDatePickerWithLabelWithoutDescription() {
        // language=HTML
        var expectedHtmlFragment = """
            <div id="form-field-appointment" class="utrecht-form-field utrecht-form-field--date-picker">
              <div class="utrecht-form-field__label">
                <label
                  for="control-date"
                  class="utrecht-form-label"
                >Appointment Date</label>
              </div>
              <div id="description-label" class="utrecht-form-field-description utrecht-form-field__description"></div>
              <div id="error-message-label" class="utrecht-form-field__error-message"></div>
              <div class="utrecht-form-field__input">
                <rods-date-picker
                  value=""
                  name="control"
                  id="control-date"
                  class="rods-date-picker"
                ></rods-date-picker>
              </div>
            </div>""";

        var component = new RdFormFieldDatePicker<>(
            "component",
            Model.of(""),
            Model.of("Appointment Date")
        );

        setSubjectUnderTestIds(component);

        String actualHtmlFragment = renderComponentInDivTestPanel(component);

        verifyFormFieldContract(component, actualHtmlFragment);
        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    private void setSubjectUnderTestIds(RdFormFieldDatePicker<?> component) {
        component.setMarkupId("form-field-appointment");
        component.getDatePicker().setMarkupId("control-date");
        component.getDescriptionComponent().setMarkupId("description-label");
        component.getErrorMessageComponent().setMarkupId("error-message-label");
    }
}
