package nl.rotterdam.nl_design_system.wicket.components.text_input;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions.assertHeaderItemExists;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

class RdTextInputBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertResourceReferenceExists() {
        assertHeaderItemExists(
            cssReferenceHeaderItem(RdTextInputBehavior.class, "@utrecht/textbox-css/dist/index.min.css")
        );
    }
}
