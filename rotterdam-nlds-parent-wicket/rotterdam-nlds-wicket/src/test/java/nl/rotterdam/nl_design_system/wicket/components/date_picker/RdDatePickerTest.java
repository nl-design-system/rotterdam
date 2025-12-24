package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdDatePickerTest extends NldsWicketTestCase {

    @Test
    void renderMinimal() {
        Component datePicker = new RdDatePicker<>("appointmentDate", () -> "2025-12-31T10:05")
            .setMarkup(Markup.of("<rods-date-picker wicket:id='appointmentDate'></rods-date-picker>"))
            .setMarkupId("appointmentDate");

        // language=HTML
        String expectedHtmlFragment = """
            <rods-date-picker
              value="2025-12-31T10:05"
              name="appointmentDate"
              id="appointmentDate"
              class="rods-date-picker">
            </rods-date-picker>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(datePicker).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void renderWithoutValue() {
        Component datePicker = new RdDatePicker<String>("appointmentDate", () -> null)
            .setMarkup(Markup.of("<rods-date-picker wicket:id='appointmentDate'></rods-date-picker>"))
            .setMarkupId("appointmentDate");

        // language=HTML
        String expectedHtmlFragment = """
            <rods-date-picker
              name="appointmentDate"
              id="appointmentDate"
              class="rods-date-picker">
            </rods-date-picker>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(datePicker).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

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

        throw new RuntimeException("TODO in progress");
    }
}
