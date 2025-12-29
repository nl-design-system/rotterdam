package nl.rotterdam.nl_design_system.docs.wicket.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.date_picker.RdDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;

import java.time.LocalDateTime;

public class DatePickerExamplesPanel extends ExamplesPanel {
    public DatePickerExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDatePicker.class;
    }

    @ComponentExample
    private static RdDatePicker exampleDatePicker() {
        return new RdDatePicker(
            "datePicker",
            Model.of(LocalDateTime.of(2025, 12, 31, 10, 5))
        );
    }

    @ComponentExample
    private static RdDatePicker exampleDatePickerEmpty() {
        return new RdDatePicker(
            "datePickerEmpty",
            DefaultModels.NULL_LOCAL_DATE_TIME
        );
    }

    @ComponentExample
    private static RdDatePicker exampleDatePickerDisabled() {
        RdDatePicker component = new RdDatePicker(
            "datePickerDisabled",
            Model.of(LocalDateTime.of(2025, 1, 15, 14, 30))
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdDatePicker exampleDatePickerRequired() {
        RdDatePicker component = new RdDatePicker(
            "datePickerRequired",
            DefaultModels.NULL_LOCAL_DATE_TIME
        );
        component.setRequired(true);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleDatePicker(),
            exampleDatePickerEmpty(),
            exampleDatePickerDisabled(),
            exampleDatePickerRequired()
        );
    }
}
