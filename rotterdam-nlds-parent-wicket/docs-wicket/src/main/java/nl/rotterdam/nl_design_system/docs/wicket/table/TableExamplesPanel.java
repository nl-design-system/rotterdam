package nl.rotterdam.nl_design_system.docs.wicket.table;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.table.RdDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableExamplesPanel extends ExamplesPanel {
    public TableExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDataTable.class;
    }

    @ComponentExample
    private static RdDataTable<Person, String> exampleBasicTable() {


        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Naam"), PersonSortableDataProvider.SORT_NAME, "name"),
            new PropertyColumn<>(Model.of("E-mail"), PersonSortableDataProvider.SORT_EMAIL, "email"),
            new PropertyColumn<>(Model.of("Telefoon"), "phone")
        );

        List<Person> data = Arrays.asList(
            new Person("Jan Jansen", "jan.jansen@example.com",  "06-12345678"),
            new Person("Marie de Vries", "marie.devries@example.com", "06-87654321"),
            new Person("Pieter Bakker", "pieter.bakker@example.com", "06-11223344")
        );

        return new RdDataTable<>("basicTable", columns, new PersonSortableDataProvider(data), 10);
    }

    @ComponentExample
    private static RdDataTable<Person, String> exampleTableWithManyRows() {
        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Naam"), PersonSortableDataProvider.SORT_NAME, "name"),
            new PropertyColumn<>(Model.of("E-mail"), PersonSortableDataProvider.SORT_EMAIL, "email"),
            new PropertyColumn<>(Model.of("Telefoon"), "phone")
        );

        List<Person> data = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            data.add(new Person("Persoon " + i, "persoon" + i + "@example.com", "06-1234567" + i));
        }

        return new RdDataTable<>("tableWithManyRows", columns, new PersonSortableDataProvider(data), 10);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(exampleBasicTable(),
            exampleTableWithManyRows());
    }


}
