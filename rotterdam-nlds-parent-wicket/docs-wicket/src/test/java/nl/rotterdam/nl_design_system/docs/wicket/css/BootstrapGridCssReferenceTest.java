package nl.rotterdam.nl_design_system.docs.wicket.css;

import nl.rotterdam.nl_design_system.docs.wicket.css.bootstrap.BootstrapGridCssReference;
import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

class BootstrapGridCssReferenceTest extends NldsWicketTestCase {

    @Test
    void assertExists() {
        assertHeaderItemExists(BootstrapGridCssReference.BOOTSTRAP_GRID_CSS);
    }
}