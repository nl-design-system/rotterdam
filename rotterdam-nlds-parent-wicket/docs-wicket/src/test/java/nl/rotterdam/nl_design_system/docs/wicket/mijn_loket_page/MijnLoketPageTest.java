package nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;


class MijnLoketPageTest extends NldsWicketTestCase {

    @Test
    void renders() {
        tester.startPage(MijnLoketPage.class);
        tester.assertRenderedPage(MijnLoketPage.class);
    }
}