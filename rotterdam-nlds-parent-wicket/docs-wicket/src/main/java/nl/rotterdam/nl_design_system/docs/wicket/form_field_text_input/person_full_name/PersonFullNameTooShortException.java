package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.person_full_name;

public class PersonFullNameTooShortException extends RuntimeException {

    public PersonFullNameTooShortException(String value) {
        super("Naam is te kort: '" + value + "' (minimaal " + PersonFullName.MAXIMUM_LENGTH + " tekens vereist)");
    }
}
