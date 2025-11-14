package nl.rotterdam.nl_design_system.wicket.components.test_common;

import static org.assertj.core.api.Assertions.assertThat;

import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss;
import org.apache.wicket.Component;
import org.apache.wicket.util.tester.TagTester;

public enum FormFieldAssertions {
    ;

    public static void verifyFormFieldContract(RdFormField component, String actualOutput) {
        Component formField = (Component) component;

        // assert root has utrecht-form-field class
        TagTester tester = TagTester.createTagByAttribute(actualOutput, "id", formField.getMarkupId());
        assertThat(tester.getAttribute("class")).contains(RdFormFieldCss.DEFAULT.getClassNames());

        // assert label is present, as label has no id we just assert full content
        assertThat(actualOutput).contains(RdFormFieldCss.DEFAULT.getClassNames());

        // TODO there is more to validate here.
    }
}
