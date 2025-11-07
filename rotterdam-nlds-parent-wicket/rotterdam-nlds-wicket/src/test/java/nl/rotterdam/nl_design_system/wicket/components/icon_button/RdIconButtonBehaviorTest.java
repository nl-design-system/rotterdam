package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class RdIconButtonBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(RdIconButtonBehavior.CSS_HEADER_ITEM);
    }

}
