package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.design_system.wicket.components.test_common.WicketAssertions.assertHeaderItemExists;

class UtrechtFormFieldBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertResourceReferenceExists() {
        assertHeaderItemExists(UtrechtFormFieldBehavior.CSS_HEADER_ITEM);
    }

}