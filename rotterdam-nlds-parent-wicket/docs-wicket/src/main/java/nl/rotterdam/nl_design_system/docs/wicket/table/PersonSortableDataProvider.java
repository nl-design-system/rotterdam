package nl.rotterdam.nl_design_system.docs.wicket.table;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;

import java.io.Serial;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Wicket 10 / Java 21 list-backed sortable provider for Person.
 *
 * Sort properties:
 *  - "name"
 *  - "email"
 */
public final class PersonSortableDataProvider extends SortableDataProvider<Person, String> {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String SORT_NAME  = "name";
    public static final String SORT_EMAIL = "email";

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

        Comparator<Person> comparator = comparatorFor(sort == null ? null : sort.getProperty());

        if (sort != null && !sort.isAscending()) {
            comparator = comparator.reversed();
        }

        return persons.stream().sorted(comparator);
    }

    private static Comparator<Person> comparatorFor(String property) {
        Comparator<String> nullSafeString = Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER);

        if (SORT_EMAIL.equals(property)) {
            return Comparator.comparing(Person::email, nullSafeString)
                    .thenComparing(Person::name, nullSafeString);
        }

        // default: name
        return Comparator.comparing(Person::name, nullSafeString)
                .thenComparing(Person::email, nullSafeString);
    }
}
