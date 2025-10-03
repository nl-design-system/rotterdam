package nl.rotterdam.design_system.wicket.components.button;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.markup.html.IHeaderResponseDecorator;
import org.junit.jupiter.api.Test;


import static nl.rotterdam.design_system.wicket.components.test_common.WicketAssertions.assertHeaderItemExists;

class NlButtonBehaviorTest extends NldsWicketTestCase {

    @Test
    void assertCssExists() {


        assertHeaderItemExists(NlButtonBehavior.CSS_HEADER_ITEM);
    }
}


