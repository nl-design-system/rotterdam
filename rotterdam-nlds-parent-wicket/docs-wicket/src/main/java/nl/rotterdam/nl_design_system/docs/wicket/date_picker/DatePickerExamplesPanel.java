package nl.rotterdam.nl_design_system.docs.wicket.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.date_picker.RdDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatePickerExamplesPanel extends ExamplesPanel {
    public DatePickerExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDatePicker.class;
    }

    @ComponentExample
    private static Component exampleDatePicker() {
        return new RdDatePicker(
            "datePicker",
            Model.of(LocalDateTime.of(2025, 12, 31, 10, 5))
        );
    }

    @ComponentExample
    private static Component exampleDatePickerEmpty() {
        return new RdDatePicker(
            "datePickerEmpty",
            DefaultModels.NULL_LOCAL_DATE_TIME
        );
    }

    @ComponentExample
    private static Component exampleDatePickerDisabled() {
        return new RdDatePicker(
            "datePickerDisabled",
            Model.of(LocalDateTime.of(2025, 1, 15, 14, 30))
        )
            .setEnabled(false);
    }

    @ComponentExample
    private static Component exampleDatePickerRequired() {
        return new RdDatePicker(
            "datePickerRequired",
            DefaultModels.NULL_LOCAL_DATE_TIME
        ).setRequired(true);
    }

    @ComponentExample
    private static Component exampleDatePickerWithAvailableDateTimesDesktop() {

        return createDatePickerWithTwoDaysWithAvailableTimes("datePickerWithAvailableDateTimesDesktop");
    }

    @ComponentExample
    private static Component exampleDatePickerWithAvailableDateTimesMobile() {

        return createDatePickerWithTwoDaysWithAvailableTimes("datePickerWithAvailableDateTimesMobile");
    }

    private static FormComponent<LocalDateTime> createDatePickerWithTwoDaysWithAvailableTimes(String componentId) {
        var selectableTimes = List.of(
            LocalDateTime.of(2026, 1, 15, 10, 0),
            LocalDateTime.of(2026, 1, 15, 11, 0),
            LocalDateTime.of(2026, 1, 15, 13, 0),
            LocalDateTime.of(2026, 1, 15, 14, 0),
            LocalDateTime.of(2026, 1, 16, 10, 0),
            LocalDateTime.of(2026, 1, 16, 12, 0),
            LocalDateTime.of(2026, 1, 16, 16, 0)
        );

        return new RdDatePicker(
            componentId,
            Model.of()
        )
            .withAvailableDateTimes(new CollectionModel<>(selectableTimes))
            .setRequired(true);
    }

    @ComponentExample
    private static Component exampleDatePickerWithManyAvailableDateTimes() {
        var selectableTimes = new ArrayList<LocalDateTime>();
        var date = LocalDate.now();
        for (int i = 0; i < 90; i++) {
            var currentDay = date.plusDays(i);
            var dayOfWeek = currentDay.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                for (int hour = 9; hour < 17; hour++) {
                    for (int minute = 0; minute < 60; minute += 10) {
                        selectableTimes.add(currentDay.atTime(hour, minute));
                    }
                }
            }
        }

        return new RdDatePicker(
            "datePickerWithManyAvailableDateTimes",
            Model.of()
        )
        .withAvailableDateTimes(new CollectionModel<>(selectableTimes))
        .setRequired(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleDatePickerWithAvailableDateTimesDesktop(),
            exampleDatePickerWithAvailableDateTimesMobile(),
            exampleDatePickerWithManyAvailableDateTimes(),
            exampleDatePicker(),
            exampleDatePickerEmpty(),
            exampleDatePickerDisabled(),
            exampleDatePickerRequired()
        );
    }
}
