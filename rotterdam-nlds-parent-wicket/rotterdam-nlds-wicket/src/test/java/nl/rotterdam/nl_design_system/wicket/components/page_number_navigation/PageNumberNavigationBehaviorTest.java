package nl.rotterdam.nl_design_system.wicket.components.page_number_navigation;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class PageNumberNavigationBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(PageNumberNavigationBehavior.CSS_HEADER_ITEM);
    }
}