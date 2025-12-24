package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RdDataTableTest extends NldsWicketTestCase {

    @Test
    void testHtmlAsExpected() {

        // language=HTML
        var expectedHtmlFragment =
            """
                <table class="utrecht-table" id="component">
                  <caption class="utrecht-table__caption">Personen voor demo-doeleinden</caption>
                  <thead class="utrecht-table__header">
                  <tr class="utrecht-table__row">
                    <th aria-sort="ascending" class="utrecht-table__header-cell" scope="col">
                      <form action="./wicket/page" id="sortForm1" method="get">
                        <div class="hidden-fields" hidden id="sortForm1_hf_0">
                          <input name="0-0.-static-component-topToolbars-toolbars-2-headers-1-header-sortForm" type="hidden" value="">
                        </div>
                        <button class="utrecht-button utrecht-button--html-button utrecht-button--subtle utrecht-table__header-cell-button" id="orderByButton2" name="orderByButton">
                        <span aria-hidden="true" class="utrecht-icon" role="presentation"><svg class="tabler-icon tabler-icon-sort-ascending" fill="none" height="24" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                                              <path d="M4 6l7 0"></path><path d="M4 12l7 0"></path><path d="M4 18l9 0"></path><path d="M15 9l3 -3l3 3"></path><path d="M18 6l0 12"></path>
                                            </svg>\s
                                        </span> <span>Name</span></button>
                      </form>
                    </th>
                    <th aria-sort="none" class="utrecht-table__header-cell" scope="col">
                      <form action="./wicket/page" id="sortForm3" method="get">
                        <div class="hidden-fields" hidden id="sortForm3_hf_0">
                          <input name="0-0.-static-component-topToolbars-toolbars-2-headers-2-header-sortForm" type="hidden" value="">
                        </div>
                        <button class="utrecht-button utrecht-button--html-button utrecht-button--subtle utrecht-table__header-cell-button" id="orderByButton4" name="orderByButton"><span aria-hidden="true" class="utrecht-icon" role="presentation"><svg class="tabler-icon tabler-icon-arrows-sort" fill="none" height="24" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                                              <path d="M3 9l4 -4l4 4m-4 -4v14"></path><path d="M21 15l-4 4l-4 -4m4 4v-14"></path>
                                            </svg>\s
                                        </span> <span>Email</span></button>
                      </form>
                    </th>
                    <th class="utrecht-table__header-cell" scope="col"><span>Leeftijd</span></th>
                  </tr>
                  </thead>
                  <tbody>
                   <tr class="utrecht-table__row utrecht-table__row--alternate-even">
                               <td class="utrecht-table__cell">
                                   <div>Jane Smith</div>
                               </td>
                               <td class="utrecht-table__cell">
                                   <div>jane@example.com</div>
                               </td>
                               <td class="utrecht-table__cell">
                                   <div>45</div>
                               </td>
                           </tr>
                           <tr class="utrecht-table__row utrecht-table__row--alternate-odd">
                               <td class="utrecht-table__cell">
                                   <div>John Doe</div>
                               </td>
                               <td class="utrecht-table__cell">
                                   <div>john@example.com</div>
                               </td>
                               <td class="utrecht-table__cell">
                                   <div>35</div>
                               </td>
                           </tr>
                  </tbody>
                </table>
                """;

        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Name"), "name", "name"),
            new PropertyColumn<>(Model.of("Email"), "email", "email"),
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


        setSubjectUnderTestIds(table);


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
        List<IColumn<Person, String>> columns = List.of(
            new PropertyColumn<>(Model.of("Name"), "name")
        );

        var dataProvider = new PersonSortableDataProvider(List.of(new Person("John Doe", "john@example.com", 35)));
        var table = new RdDataTable<>("component", columns, dataProvider, 10);

        var response = renderComponentInTableTestPanel(table);

        // Verify the CSS header item is rendered
        assertTrue(response.contains("utrecht-table"), "Should have Utrecht table CSS classes");
    }


    private void setSubjectUnderTestIds(RdDataTable<?,?> component) {
        component.setMarkupId("component");
    }

}
