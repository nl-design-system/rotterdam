package nl.rotterdam.nl_design_system.docs.wicket.css;

import nl.rotterdam.nl_design_system.docs.wicket.css.bootstrap.BootstrapCssReference;
import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class BootstrapCssReferenceTest extends NldsWicketTestCase {

    @Test
    void assertExists() {
        assertHeaderItemExists(BootstrapCssReference.BOOTSTRAP_GRID_CSS);
        assertHeaderItemExists(BootstrapCssReference.BOOTSTRAP_UTILITIES_CSS);
    }
}