package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;


class ComponentsExamplePageTest extends NldsWicketTestCase {

    @Test
    void renders() {
        tester.startPage(ComponentsExamplePage.class);
        tester.assertRenderedPage(ComponentsExamplePage.class);
    }
}