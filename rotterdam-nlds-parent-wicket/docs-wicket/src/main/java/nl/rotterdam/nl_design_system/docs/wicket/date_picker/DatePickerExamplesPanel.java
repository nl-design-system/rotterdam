package nl.rotterdam.nl_design_system.docs.wicket.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.date_picker.RdDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.Nullable;

public class DatePickerExamplesPanel extends ExamplesPanel {
    public DatePickerExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDatePicker.class;
    }

    @ComponentExample
    private static RdDatePicker<String> exampleDatePicker() {
        return new RdDatePicker<>(
            "datePicker",
            Model.of("2025-12-31T10:05")
        );
    }

    @ComponentExample
    private static RdDatePicker<@Nullable String> exampleDatePickerEmpty() {
        return new RdDatePicker<>(
            "datePickerEmpty",
            DefaultModels.NULL_STRING_MODEL
        );
    }

    @ComponentExample
    private static RdDatePicker<String> exampleDatePickerDisabled() {
        RdDatePicker<String> component = new RdDatePicker<>(
            "datePickerDisabled",
            Model.of("2025-01-15T14:30")
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdDatePicker<@Nullable String> exampleDatePickerRequired() {
        RdDatePicker<@Nullable String> component = new RdDatePicker<>(
            "datePickerRequired",
            DefaultModels.NULL_STRING_MODEL
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
