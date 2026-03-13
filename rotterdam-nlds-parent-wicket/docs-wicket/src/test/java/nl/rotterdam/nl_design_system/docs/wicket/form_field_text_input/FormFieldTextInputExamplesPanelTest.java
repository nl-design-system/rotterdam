package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input;

import nl.rotterdam.nl_design_system.docs.wicket.DocsWicketTestCase;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static nl.rotterdam.nl_design_system.docs.wicket.DocsLocale.LOCALE_DUTCH;

class FormFieldTextInputExamplesPanelTest  extends DocsWicketTestCase {

    @Test
    void correctErrorMessageIsRenderedForLocaleEnglish() {
        tester.startComponentInPage(FormFieldTextInputExamplesPanel.class);
        tester.getSession().setLocale(Locale.ENGLISH);

        tester.newFormTester("formFieldTextInputWithValueType")
            .setValue("personFullName:input-container:control", "123")
            .submit();

        tester.assertErrorMessages("Full name must have at least 5 characters");
    }

    @Test
    void correctErrorMessageIsRenderedForLocaleDutch() {
        tester.startComponentInPage(FormFieldTextInputExamplesPanel.class);
        tester.getSession().setLocale(LOCALE_DUTCH);

        tester.newFormTester("formFieldTextInputWithValueType")
            .setValue("personFullName:input-container:control", "123")
            .submit();

        tester.assertErrorMessages("Volledige naam moet minimaal 5 tekens bevatten");
    }
}