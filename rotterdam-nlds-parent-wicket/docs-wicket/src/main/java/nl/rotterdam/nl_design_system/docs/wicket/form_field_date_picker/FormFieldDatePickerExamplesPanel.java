package nl.rotterdam.nl_design_system.docs.wicket.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker.RdFormFieldDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;

import java.time.LocalDateTime;
import java.util.List;

public class FormFieldDatePickerExamplesPanel extends ExamplesPanel {
    public FormFieldDatePickerExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldDatePicker.class;
    }

    @ComponentExample
    private static RdFormFieldDatePicker exampleFormFieldDatePicker() {
        return new RdFormFieldDatePicker(
            "formFieldDatePicker",
            Model.of(LocalDateTime.of(2025, 12, 31, 10, 5)),
            Model.of("Afspraak datum"),
            Model.of("Selecteer een datum en tijd voor je afspraak.")
        );
    }

    @ComponentExample
    private static RdFormFieldDatePicker exampleFormFieldDatePickerRequired() {
        return new RdFormFieldDatePicker(
            "formFieldDatePickerRequired",
            DefaultModels.NULL_LOCAL_DATE_TIME,
            Model.of("Gewenste datum en tijd")
        )
            .setRequired(true);
    }

    @ComponentExample
    private static Component exampleFormFieldDatePickerWithErrorMessage() {
        var component = new RdFormFieldDatePicker("formFieldDatePickerWithErrorMessage", Model.of(LocalDateTime.of(2025, 12, 31, 10, 0)), Model.of("Selecteer datum en tijd"));
        component.getDatePicker().error("Het gekozen tijdstip is niet meer beschikbaar. Kies een andere datum en tijd.");
        return component;
    }

    @ComponentExample
    private static RdFormFieldDatePicker exampleFormFieldDatePickerDisabled() {
        RdFormFieldDatePicker component = new RdFormFieldDatePicker(
            "formFieldDatePickerDisabled",
            Model.of(LocalDateTime.of(2025, 1, 15, 14, 30)),
            Model.of("Geboortedatum"),
            Model.of("Je geboortedatum.")
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFormFieldDatePicker exampleFormFieldDatePickerWithoutDescription() {
        return new RdFormFieldDatePicker(
            "formFieldDatePickerWithoutDescription",
            Model.of(LocalDateTime.of(2025, 6, 1, 9, 0)),
            Model.of("Aanvangsdatum")
        );
    }

    @ComponentExample
    private static RdFormFieldDatePicker exampleFormFieldDatePickerWithAvailableTimes() {
        var availableTimes = List.of(
            LocalDateTime.of(2026, 2, 10, 9, 0),
            LocalDateTime.of(2026, 2, 10, 10, 30),
            LocalDateTime.of(2026, 2, 10, 14, 0),
            LocalDateTime.of(2026, 2, 11, 9, 0),
            LocalDateTime.of(2026, 2, 11, 11, 0)
        );

        return new RdFormFieldDatePicker(
            "formFieldDatePickerWithAvailableTimes",
            DefaultModels.NULL_LOCAL_DATE_TIME,
            Model.of("Kies een afspraakmoment"),
            Model.of("Selecteer een beschikbaar tijdslot.")
        )
        .withDatePicker((datePicker, formField) ->
            datePicker.withAvailableDateTimes(new CollectionModel<>(availableTimes))
        )
        .setRequired(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldDatePicker(),
            exampleFormFieldDatePickerRequired(),
            exampleFormFieldDatePickerDisabled(),
            exampleFormFieldDatePickerWithoutDescription(),
            exampleFormFieldDatePickerWithErrorMessage(),
            exampleFormFieldDatePickerWithAvailableTimes()
        );
    }
}
