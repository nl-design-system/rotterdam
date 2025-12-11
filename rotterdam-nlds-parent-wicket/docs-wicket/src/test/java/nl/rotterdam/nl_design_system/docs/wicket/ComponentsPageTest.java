package nl.rotterdam.nl_design_system.docs.wicket;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.IReferenceHeaderItem;
import org.apache.wicket.markup.head.filter.FilteringHeaderResponse;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.markup.html.IHeaderResponseDecorator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ComponentsPageTest extends NldsWicketTestCase {

    @Test
    void pageRenders() {
        CapturingHeaderResponseDecorator decorator = new CapturingHeaderResponseDecorator();

        tester.getApplication().getHeaderResponseDecorators().add(decorator);

        tester.startPage(ComponentsPage.class);
        tester.assertRenderedPage(ComponentsPage.class);

        decorator
            .getCapturedItems()
            .stream()
            .filter(item -> (item instanceof IReferenceHeaderItem))
            .map(item -> (IReferenceHeaderItem) item)
            .forEach(WicketAssertions::assertHeaderItemExists);
    }
}

class CapturingHeaderResponseDecorator implements IHeaderResponseDecorator {

    private final List<HeaderItem> capturedItems = new ArrayList<>();

    @Override
    public IHeaderResponse decorate(IHeaderResponse response) {
        // Wrap the response so we can intercept render()
        return new FilteringHeaderResponse(new JavaScriptFilteredIntoFooterHeaderResponse(response, "footer")) {
            @Override
            public void render(HeaderItem item) {
                capturedItems.add(item);
                super.render(item);
            }
        };
    }

    public List<HeaderItem> getCapturedItems() {
        return capturedItems;
    }
}
