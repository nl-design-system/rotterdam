package nl.rotterdam.nl_design_system.docs.wicket.table;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serial;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * List-backed sortable provider for Person.
 */
public final class PersonSortableDataProvider extends SortableDataProvider<Person, String> {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SORT_NAME = "name";
    public static final String SORT_EMAIL = "email";
    public static final String SORT_STREET = "street";

    private final List<Person> persons; // immutable input expected

    public PersonSortableDataProvider(List<Person> persons) {
        this.persons = List.copyOf(Objects.requireNonNull(persons, "persons"));
        // default sorting
        setSort(SORT_NAME, SortOrder.ASCENDING);
    }

    @Override
    public Iterator<? extends Person> iterator(long first, long count) {
        return sortedStream()
            .skip(first)
            .limit(count)
            .iterator();
    }

    @Override
    public long size() {
        return persons.size();
    }

    @Override
    public IModel<Person> model(Person object) {
        // For an immutable record list this is fine.
        // If you later load/edit entities, use a detachable model keyed by ID.
        return Model.of(object);
    }

    private Stream<Person> sortedStream() {
        SortParam<String> sort = getSort();

        if (sort == null) {
            return persons.stream();
        }

        Comparator<Person> comparator = comparatorFor(sort.getProperty());

        if (!sort.isAscending()) {
            comparator = comparator.reversed();
        }

        return persons.stream().sorted(comparator);
    }

    private static final Map<String, Function<Person, String>> sortFunctions =
        Map.of(
            SORT_EMAIL, Person::email,
            SORT_NAME, Person::name,
            SORT_STREET, Person::street
        );

    private static Comparator<Person> comparatorFor(String property) {
        Function<Person, String> function = sortFunctions.get(property);
        Objects.requireNonNull(function, () -> "Unknown property: " + property);
        return Comparator.comparing(function, Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER));
    }
}
