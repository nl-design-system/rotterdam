package nl.rotterdam.wicket.docs;

import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.jupiter.api.Test;

class ComponentsPageTest extends WicketTestCase {

    @Test
    void pageRenders() {
        tester.startPage(ComponentsPage.class);
        tester.assertRenderedPage(ComponentsPage.class);
    }
}