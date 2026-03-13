package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.person_full_name;

public class PersonFullNameTooLongException extends RuntimeException {

    public PersonFullNameTooLongException(String value) {
        super("Naam is te lang: " + value.length() + " tekens (maximaal " + PersonFullName.MAXIMUM_LENGTH  + " tekens toegestaan)");
    }
}
