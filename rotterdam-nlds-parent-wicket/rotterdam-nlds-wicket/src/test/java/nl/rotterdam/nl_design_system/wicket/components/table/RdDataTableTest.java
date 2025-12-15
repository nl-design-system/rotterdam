package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RdDataTableTest extends NldsWicketTestCase {


    @Disabled("WIP")
    @Test
    void testHtmlAsExpected() {

        // language=HTML
        var expectedHtmlFragment =
            """
                <table class="utrecht-table">
                  <caption class="utrecht-table__caption">
                    Personen voor demo-doeleinden
                  </caption>
                  <thead class="utrecht-table__header">
                    <tr class="utrecht-table__row">
                      <th scope="col" aria-sort="none" class="utrecht-table__header-cell">
                        <button
                          class="utrecht-button utrecht-table__header-cell-button"
                          type="button"
                        >
                          <span class="utrecht-icon" role="presentation" aria-hidden="true"
                            ><svg
                              xmlns="http://www.w3.org/2000/svg"
                              width="24"
                              height="24"
                              viewBox="0 0 24 24"
                              fill="none"
                              stroke="currentColor"
                              stroke-width="2"
                              stroke-linecap="round"
                              stroke-linejoin="round"
                              class="tabler-icon tabler-icon-arrows-sort"
                            >
                              <path d="M3 9l4 -4l4 4m-4 -4v14"></path>
                              <path d="M21 15l-4 4l-4 -4m4 4v-14"></path></svg></span
                          >Naam
                        </button>
                      </th>
                      <th
                        scope="col"
                        class="utrecht-table__header-cell"
                      >
                        <button
                          class="utrecht-button utrecht-table__header-cell-button"
                          type="button"
                        >
                          <span class="utrecht-icon" role="presentation" aria-hidden="true"
                            ><svg
                              xmlns="http://www.w3.org/2000/svg"
                              width="24"
                              height="24"
                              viewBox="0 0 24 24"
                              fill="none"
                              stroke="currentColor"
                              stroke-width="2"
                              stroke-linecap="round"
                              stroke-linejoin="round"
                              class="tabler-icon tabler-icon-arrows-sort"
                            >
                              <path d="M3 9l4 -4l4 4m-4 -4v14"></path>
                              <path d="M21 15l-4 4l-4 -4m4 4v-14"></path></svg></span
                          >Email
                        </button>
                      </th>
                      <th
                        scope="col"
                        class="utrecht-table__header-cell utrecht-table__header-cell--numeric-column"
                      >
                        <button
                          class="utrecht-button utrecht-table__header-cell-button"
                          type="button"
                        >
                          <span class="utrecht-icon" role="presentation" aria-hidden="true"
                            ><svg
                              xmlns="http://www.w3.org/2000/svg"
                              width="24"
                              height="24"
                              viewBox="0 0 24 24"
                              fill="none"
                              stroke="currentColor"
                              stroke-width="2"
                              stroke-linecap="round"
                              stroke-linejoin="round"
                              class="tabler-icon tabler-icon-arrows-sort"
                            >
                              <path d="M3 9l4 -4l4 4m-4 -4v14"></path>
                              <path d="M21 15l-4 4l-4 -4m4 4v-14"></path></svg></span
                          >Leeftijd
                        </button>
                      </th>
                    </tr>
                  </thead>
                  <tbody class="utrecht-table__body">
                    <tr class="utrecht-table__row">
                      <th scope="row" class="utrecht-table__header-cell">Locatie A</th>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        53
                      </td>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        113
                      </td>
                    </tr>
                    <tr class="utrecht-table__row">
                      <th scope="row" class="utrecht-table__header-cell">Locatie B</th>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        58
                      </td>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        42
                      </td>
                    </tr>
                    <tr class="utrecht-table__row">
                      <th scope="row" class="utrecht-table__header-cell">Locatie C</th>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        87
                      </td>
                      <td class="utrecht-table__cell utrecht-table__cell--numeric-column">
                        16
                      </td>
                    </tr>
                  </tbody>
                </table>       
                """;



        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Name"), "name"),
            new PropertyColumn<>(Model.of("Email"), "email"),
            new PropertyColumn<>(Model.of("Leeftijd"), "age")
        );

        List<Person> data = Arrays.asList(
            new Person("John Doe", "john@example.com", 35),
            new Person("Jane Smith", "jane@example.com" ,45)
        );

        var table = new RdDataTable<>("component", columns, new PersonSortableDataProvider(data), 10) {
            @Override
            protected IModel<String> getCaptionModel() {
                 return Model.of("Personen voor demo-doeleinden");
            }
        };

        String actualHtmlFragment = renderComponentInTableTestPanel(table);

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);

    }




    @Test
    void rendersTableWithUtrechtCssClasses() {
        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Name"), "name"),
            new PropertyColumn<>(Model.of("Email"), "email")
        );

        List<Person> data = Arrays.asList(
            new Person("John Doe", "john@example.com", 35),
            new Person("Jane Smith", "jane@example.com", 40)
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

        var dataProvider = new PersonSortableDataProvider(Arrays.asList(new Person("John Doe", "john@example.com", 35)));
        var table = new RdDataTable<>("component", columns, dataProvider, 10);

        var response = renderComponentInTableTestPanel(table);

        // Verify the CSS header item is rendered
        assertTrue(response.contains("utrecht-table"), "Should have Utrecht table CSS classes");
    }

}
