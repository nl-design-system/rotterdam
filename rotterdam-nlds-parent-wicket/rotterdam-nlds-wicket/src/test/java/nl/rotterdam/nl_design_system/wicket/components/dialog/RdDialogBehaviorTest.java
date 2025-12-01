package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class RdDialogBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(RdDialogBehavior.CSS_HEADER_ITEM);
    }

}
