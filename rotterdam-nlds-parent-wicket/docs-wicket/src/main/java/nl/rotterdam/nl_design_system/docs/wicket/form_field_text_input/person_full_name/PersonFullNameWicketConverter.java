package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.person_full_name;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.jspecify.annotations.Nullable;

import java.util.Locale;

public class PersonFullNameWicketConverter implements IConverter<PersonFullName> {

    @Override
    public @Nullable PersonFullName convertToObject(String value, Locale locale) throws ConversionException {
        if (value.isBlank()) {
            return null;
        }
        try {
            return new PersonFullName(value);
        } catch (PersonFullNameTooShortException e) {
            throw new ConversionException("Naam moet minimaal 5 tekens bevatten")
                    .setResourceKey("PersonFullName.tooShort")
                    .setVariable("min", PersonFullName.MINIMUM_LENGTH)
                    .setLocale(locale);
        } catch (PersonFullNameTooLongException e) {
            throw new ConversionException("Naam moet maximaal 79 tekens bevatten")
                    .setResourceKey("PersonFullName.tooLong")
                    .setVariable("max", PersonFullName.MAXIMUM_LENGTH)
                    .setLocale(locale);
        }
    }

    @Override
    public String convertToString(PersonFullName value, Locale locale) {
        return value.value();
    }
}
