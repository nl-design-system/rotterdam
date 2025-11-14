package nl.rotterdam.nl_design_system.wicket.test_util;

import static org.assertj.core.api.Assertions.assertThat;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.util.tester.TagTester;

public enum CssClassNamesAssertions {
    ;

    public static void assertHasCss(TagTester fieldTag, CssClassNames cssClassNames) {
        assertThat(fieldTag.getAttribute("class")).contains(cssClassNames.getClassNames());
    }
}
