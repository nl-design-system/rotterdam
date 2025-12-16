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
            new PropertyColumn<>(Model.of("Telefoon"), "phone"),
            new PropertyColumn<>(Model.of("Straat"), PersonSortableDataProvider.SORT_STREET, "street"),
            new PropertyColumn<>(Model.of("Huisnummer"), "houseNumber")
            );

        List<Person> data = Arrays.asList(
            new Person("Jan Jansen", "jan.jansen@example.com",  "06-12345678", "Oranjestraat", 40),
            new Person("Marie de Vries", "marie.devries@example.com", "06-87654321", "Westersingel", 18),
            new Person("Pieter Bakker", "pieter.bakker@example.com", "06-11223344", "Rotterdamseweg", 45)
        );

        return new RdDataTable<>("basicTable", columns, new PersonSortableDataProvider(data), 10);
    }

    @ComponentExample
    private static RdDataTable<Person, String> exampleTableWithManyRows() {
        List<IColumn<Person, String>> columns = Arrays.asList(
            new PropertyColumn<>(Model.of("Naam"), PersonSortableDataProvider.SORT_NAME, "name"),
            new PropertyColumn<>(Model.of("E-mail"), PersonSortableDataProvider.SORT_EMAIL, "email"),
            new PropertyColumn<>(Model.of("Telefoon"), "phone"),
            new PropertyColumn<>(Model.of("Straat"), PersonSortableDataProvider.SORT_STREET, "street"),
            new PropertyColumn<>(Model.of("Huisnummer"), "houseNumber")
        );

        List<Person> persons = List.of(
            new Person("José Álvarez", "test+josé.alvarez@example.com", "+34 612 34 56 78", "Calle Mayor", 12),
            new Person("Zoë Müller", "dev.zoe.mueller@example.com", "+49 151 23456789", "Hauptstraße", 88),
            new Person("François Dupont", "qa_francois.dupont@example.com", "+33 6 12 34 56 78", "Rue de Rivoli", 3),
            new Person("Łukasz Kowalski", "user-lukasz.kowalski@example.com", "+48 512 345 678", "Ulica Długa", 45),
            new Person("Søren Nielsen", "soren+nielsen@example.com", "+45 20 12 34 56", "Østerbrogade", 101),

            new Person("Ana María López", "ana.maria.lopez+test@example.com", "+34 699 88 77 66", "Avenida del Sol", 7),
            new Person("Björn Åkesson", "dev_bjorn.akeson@example.com", "+46 70 123 45 67", "Storgatan", 19),
            new Person("İsmail Yılmaz", "user-ismail.yilmaz@example.com", "+90 532 123 45 67", "Atatürk Caddesi", 23),
            new Person("Renée Dubois", "qa.renee.dubois@example.com", "+33 7 98 76 54 32", "Boulevard Saint-Germain", 56),
            new Person("Jürgen Weiß", "test+juergen.weiss@example.com", "+49 160 98765432", "Goethestraße", 5),

            new Person("Márton Szabó", "dev.marton.szabo@example.com", "+36 30 123 4567", "Andrássy út", 90),
            new Person("El Niño García", "user-el.nino.garcia@example.com", "+34 611 22 33 44", "Calle del Mar", 14),
            new Person("Chloé Moreau", "chloe.moreau+qa@example.com", "+33 6 55 44 33 22", "Rue Lafayette", 77),
            new Person("Tõnu Kask", "dev_tonu.kask@example.com", "+372 512 3456", "Pärnu maantee", 120),
            new Person("Óscar Fernández", "test.oscar.fernandez@example.com", "+34 622 11 22 33", "Gran Vía", 1),

            new Person("Göran Svensson", "user-goran.svensson@example.com", "+46 72 987 65 43", "Kungsgatan", 64),
            new Person("Maëlle Leclerc", "qa_maelle.leclerc@example.com", "+33 6 44 55 66 77", "Rue Victor Hugo", 9),
            new Person("André Silva", "andre.silva+dev@example.com", "+351 912 345 678", "Rua das Flores", 31),
            new Person("Núria Pujol", "dev.nuria.pujol@example.com", "+34 633 99 88 77", "Carrer de Balmes", 52),
            new Person("Sebastián Ríos", "user-sebastian.rios@example.com", "+56 9 8765 4321", "Avenida Libertador", 210),

            new Person("Åsa Lindström", "test+asa.lindstrom@example.com", "+46 73 111 22 33", "Sveavägen", 18),
            new Person("Vítor Costa", "qa.vitor.costa@example.com", "+351 934 567 890", "Rua do Comércio", 6),
            new Person("Noémie Laurent", "dev-noemie.laurent@example.com", "+33 6 10 20 30 40", "Rue des Fleurs", 42),
            new Person("Pål Johansen", "user_pal.johansen@example.com", "+47 412 34 567", "Karl Johans gate", 99),
            new Person("Michał Nowak", "test+michal.nowak@example.com", "+48 601 234 567", "Aleje Jerozolimskie", 150)
        );

        return new RdDataTable<>("tableWithManyRows", columns, new PersonSortableDataProvider(persons), 10);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(exampleBasicTable(),
            exampleTableWithManyRows());
    }


}
