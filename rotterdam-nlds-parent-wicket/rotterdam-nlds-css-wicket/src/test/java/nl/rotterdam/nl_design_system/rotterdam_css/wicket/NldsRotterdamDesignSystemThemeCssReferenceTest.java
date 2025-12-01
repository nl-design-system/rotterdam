package nl.rotterdam.nl_design_system.rotterdam_css.wicket;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class NldsRotterdamDesignSystemThemeCssReferenceTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(NldsRotterdamDesignSystemThemeCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
    }
}
