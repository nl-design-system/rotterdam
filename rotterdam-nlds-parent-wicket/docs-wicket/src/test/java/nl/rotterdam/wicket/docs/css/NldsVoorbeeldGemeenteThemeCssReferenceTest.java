package nl.rotterdam.wicket.docs.css;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class NldsVoorbeeldGemeenteThemeCssReferenceTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {
        assertHeaderItemExists(NldsVoorbeeldGemeenteThemeCssReference.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
    }
}
