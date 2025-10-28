package nl.rotterdam.nl_design_system.wicket.components.button;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class RdButtonBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(RdButtonBehavior.CSS_HEADER_ITEM);
    }
}
