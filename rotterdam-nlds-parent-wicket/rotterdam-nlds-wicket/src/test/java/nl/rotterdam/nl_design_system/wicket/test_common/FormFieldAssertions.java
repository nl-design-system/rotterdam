package nl.rotterdam.nl_design_system.wicket.test_common;

import static org.assertj.core.api.Assertions.assertThat;

import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss;
import org.apache.wicket.Component;
import org.apache.wicket.util.tester.TagTester;

public enum FormFieldAssertions {
    ;

    public static void verifyUtrechtFormFieldContract(RdFormField component, String actualOutput) {
        Component utrechtFormField = (Component) component;

        // assert root has utrecht-form-field class
        TagTester tester = TagTester.createTagByAttribute(actualOutput, "id", utrechtFormField.getMarkupId());
        assertThat(tester.getAttribute("class")).contains(UtrechtFormFieldCss.DEFAULT.getClassNames());

        // assert label is present, as label has no id we just assert full content
        assertThat(actualOutput).contains(UtrechtFormFieldCss.DEFAULT.getClassNames());

        // TODO there is more to validate here.
    }
}
