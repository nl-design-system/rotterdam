package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.util.CollectionModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RdDatePickerTest extends NldsWicketTestCase {

    @Test
    void optionsAreFormattedAsDesiredByComponent() {
        var expected = """
            [{ "value": "2026-01-01T09:00" }, { "value": "2026-01-01T10:00" }]"""
            .trim();

        String jsonString = RdDatePicker.toJson(List.of(
            LocalDateTime.of(2026, 1, 1, 9, 0),
            LocalDateTime.of(2026, 1, 1, 10, 0))
        );

        assertEquals(expected, jsonString);
    }

    @Test
    void renderMinimal() {
        Component datePicker = new RdDatePicker("appointmentDate", () -> LocalDateTime.of(2025, 12, 31, 10, 5))
            .setMarkup(Markup.of("<rods-date-picker wicket:id='appointmentDate'></rods-date-picker>"))
            .setMarkupId("appointmentDate");

        // language=HTML
        String expectedHtmlFragment = """
            <rods-date-picker
              value="2025-12-31T10:05"
              name="appointmentDate"
              id="appointmentDate"
              class="rods-date-picker"></rods-date-picker>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(datePicker).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void renderWithoutValue() {
        Component datePicker = new RdDatePicker("appointmentDate", () -> null)
            .setMarkup(Markup.of("<rods-date-picker wicket:id='appointmentDate'></rods-date-picker>"))
            .setMarkupId("appointmentDate");

        // language=HTML
        String expectedHtmlFragment = """
            <rods-date-picker
              name="appointmentDate"
              id="appointmentDate"
              class="rods-date-picker"></rods-date-picker>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(datePicker).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }


    @Disabled("Not implemented yet")
    @Test
    void renderWithWijzigenButton() {
        // as discussed with Robbert.
        // language=HTML
        String expectedHtml =
            """
<rods-date-picker>
  <span slot="label">Afspraak wijzigen</span>
  <span slot="description">Je kunt de afspraak tot 24 uur van tevoren wijzigen</span>
</rods-date-picker>""";

        throw new RuntimeException("TODO in progress" + expectedHtml);
    }


    @Test
    void renderWithoutValueWithOptionsToSelectFrom() {
        var selectableTimes = List.of(
            LocalDateTime.of(2026, 1, 15, 10, 0),
            LocalDateTime.of(2026, 1, 15, 11, 0),
            LocalDateTime.of(2026, 1, 15, 13, 0),
            LocalDateTime.of(2026, 1, 15, 14, 0),
            LocalDateTime.of(2026, 1, 16, 10, 0),
            LocalDateTime.of(2026, 1, 16, 12, 0),
            LocalDateTime.of(2026, 1, 16, 16, 0)
        );

        Component datePicker = new RdDatePicker("appointmentDate", () -> null)
            .withAvailableDateTimes(new CollectionModel<>(selectableTimes))
            .setMarkup(Markup.of("<rods-date-picker wicket:id='appointmentDate'></rods-date-picker>"))
            .setMarkupId("appointmentDate");

        // language=HTML
        String expectedHtmlFragment = """
            <rods-date-picker
              name="appointmentDate"
              id="appointmentDate"
              class="rods-date-picker"></rods-date-picker>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(datePicker).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);

    }

}
