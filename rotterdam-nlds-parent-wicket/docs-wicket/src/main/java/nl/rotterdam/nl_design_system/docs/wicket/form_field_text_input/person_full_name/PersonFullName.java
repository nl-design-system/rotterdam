package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.person_full_name;

import java.io.Serializable;

import static java.util.Objects.requireNonNull;

/**
 * Value type representing a person's full name (first name + last name stored as a single string).
 * <p>
 * Validates that the value is more than 4 characters and less than 80 characters.
 * Throws {@link PersonFullNameTooShortException} or {@link PersonFullNameTooLongException}
 * when the input does not meet these constraints.
 */
public record PersonFullName(String value) implements Serializable {

    public static final int MINIMUM_LENGTH = 5;
    public static final int MAXIMUM_LENGTH = 80;

    public PersonFullName {
        requireNonNull(value, "Naam mag niet null zijn");
        value = value.trim();

        if (value.length() < MINIMUM_LENGTH) {
            throw new PersonFullNameTooShortException(value);
        }
        if (value.length() >= MAXIMUM_LENGTH) {
            throw new PersonFullNameTooLongException(value);
        }
    }

}
