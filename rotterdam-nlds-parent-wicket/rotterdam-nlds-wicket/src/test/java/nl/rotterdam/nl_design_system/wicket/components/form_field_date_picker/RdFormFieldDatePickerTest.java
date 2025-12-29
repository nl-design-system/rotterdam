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
            <div class="utrecht-form-field utrecht-form-field--date-picker" id="form-field-appointment">
                      <div class="utrecht-form-field__label">
                          <label class="utrecht-form-label" for="control-date">Date</label>
                      </div>
                      <div class="utrecht-form-field-description utrecht-form-field__description" id="description-label">Select a date and time for your appointment.</div>
                      <div class="utrecht-form-field__input">
                          <rods-date-picker aria-describedby="description-label" class="rods-date-picker" id="control-date" name="static:component:input-container:control" value="2025-12-31T10:05"></rods-date-picker>
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
            <div class="utrecht-form-field utrecht-form-field--date-picker" id="form-field-appointment">
                      <div class="utrecht-form-field__label">
                          <label class="utrecht-form-label" for="control-date">Date</label>
                      </div>
                      <div class="utrecht-form-field__input">
                          <rods-date-picker class="rods-date-picker" id="control-date" name="static:component:input-container:control"></rods-date-picker>
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
