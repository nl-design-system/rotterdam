package nl.rotterdam.nl_design_system.wicket.components.form_field;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class RdFormFieldBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertResourceReferenceExists() {
        assertHeaderItemExists(RdFormFieldBehavior.CSS_HEADER_ITEM);
    }
}
