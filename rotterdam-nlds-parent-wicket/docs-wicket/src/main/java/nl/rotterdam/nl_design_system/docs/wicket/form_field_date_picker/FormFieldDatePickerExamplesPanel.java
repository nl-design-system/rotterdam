package nl.rotterdam.nl_design_system.docs.wicket.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker.RdFormFieldDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.Nullable;

public class FormFieldDatePickerExamplesPanel extends ExamplesPanel {
    public FormFieldDatePickerExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldDatePicker.class;
    }

    @ComponentExample
    private static RdFormFieldDatePicker<String> exampleFormFieldDatePicker() {
        return new RdFormFieldDatePicker<>(
            "formFieldDatePicker",
            Model.of("2025-12-31T10:05"),
            Model.of("Afspraak datum"),
            Model.of("Selecteer een datum en tijd voor je afspraak.")
        );
    }

    @ComponentExample
    private static RdFormFieldDatePicker<@Nullable String> exampleFormFieldDatePickerRequired() {
        return new RdFormFieldDatePicker<>(
            "formFieldDatePickerRequired",
            DefaultModels.NULL_STRING_MODEL,
            Model.of("Gewenste datum en tijd")
        )
            .setRequired(true);
    }

    @ComponentExample
    private static RdFormFieldDatePicker<String> exampleFormFieldDatePickerDisabled() {
        RdFormFieldDatePicker<String> component = new RdFormFieldDatePicker<>(
            "formFieldDatePickerDisabled",
            Model.of("2025-01-15T14:30"),
            Model.of("Geboortedatum"),
            Model.of("Je geboortedatum.")
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFormFieldDatePicker<String> exampleFormFieldDatePickerWithoutDescription() {
        return new RdFormFieldDatePicker<>(
            "formFieldDatePickerWithoutDescription",
            Model.of("2025-06-01T09:00"),
            Model.of("Aanvangsdatum")
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldDatePicker(),
            exampleFormFieldDatePickerRequired(),
            exampleFormFieldDatePickerDisabled(),
            exampleFormFieldDatePickerWithoutDescription()
        );
    }
}
