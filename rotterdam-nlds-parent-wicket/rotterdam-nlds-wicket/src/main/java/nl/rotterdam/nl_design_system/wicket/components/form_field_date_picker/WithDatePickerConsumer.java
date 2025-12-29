package nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.date_picker.RdDatePicker;

/**
 * <p>
 * Implement (with lambda) to execute logic to modify the Date Picker and/or Form Field.
 * </p>
 */
@FunctionalInterface
public interface WithDatePickerConsumer {

    /**
     * <p>
     * Modify the input and/or Form Field. For example: add additional validators or behaviors.
     * </p>
     *
     * @param datePicker the Date Picker in the Form Field.
     * @param formField the Form Field.
     */
    void doWithDatePicker(RdDatePicker datePicker, RdFormFieldDatePicker formField);
}
