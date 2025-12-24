package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class RdDatePickerBehaviorTest extends NldsWicketTestCase {

    @Test
    void resourceExists() {
        assertHeaderItemExists(RdDatePickerBehavior.HEADER_ITEM);
    }
}