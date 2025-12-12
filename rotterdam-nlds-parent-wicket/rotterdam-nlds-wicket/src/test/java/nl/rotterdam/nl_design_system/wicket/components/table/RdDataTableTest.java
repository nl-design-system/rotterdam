package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RdDataTableTest extends NldsWicketTestCase {

    @Test
    void rendersTableWithUtrechtCssClasses() {
        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Name"), "name"),
            new PropertyColumn<>(Model.of("Email"), "email")
        );

        List<Person> data = Arrays.asList(
            new Person("John Doe", "john@example.com"),
            new Person("Jane Smith", "jane@example.com")
        );

        var table = new RdDataTable<>("component", columns, new PersonSortableDataProvider(data), 10);

        String document = renderComponentInTableTestPanel(table);

        var tableTester = TagTester.createTagByAttribute(document, "class", "utrecht-table");

        assertNotNull(tableTester, "Table should have utrecht-table class");
        assertTrue(document.contains("John Doe"), "Table should contain data");
        assertTrue(document.contains("jane@example.com"), "Table should contain data");
    }

    @Test
    void hasTableBehavior() {
        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Name"), "name")
        );

        var dataProvider = new PersonSortableDataProvider(Arrays.asList(new Person("Test", "test@example.com")));
        var table = new RdDataTable<>("component", columns, dataProvider, 10);

        var response = renderComponentInTableTestPanel(table);

        // Verify the CSS header item is rendered
        assertTrue(response.contains("utrecht-table"), "Should have Utrecht table CSS classes");
    }

}
