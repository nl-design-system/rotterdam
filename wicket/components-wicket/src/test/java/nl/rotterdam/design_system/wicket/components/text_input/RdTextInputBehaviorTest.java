package nl.rotterdam.design_system.wicket.components.text_input;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.design_system.wicket.components.test_common.WicketAssertions.assertHeaderItemExists;

class RdTextInputBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertResourceReferenceExists() {
        assertHeaderItemExists(RdTextInputBehavior.CSS_HEADER_ITEM);
    }

}