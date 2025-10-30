package nl.rotterdam.nl_design_system.wicket.components.form_field.utrecht;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class UtrechtFormFieldBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertResourceReferenceExists() {
        assertHeaderItemExists(UtrechtFormFieldBehavior.CSS_HEADER_ITEM);
    }
}
