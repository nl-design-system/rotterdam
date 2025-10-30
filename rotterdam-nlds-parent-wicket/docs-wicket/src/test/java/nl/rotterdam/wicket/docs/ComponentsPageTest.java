package nl.rotterdam.wicket.docs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.IReferenceHeaderItem;
import org.apache.wicket.markup.head.filter.FilteringHeaderResponse;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.markup.html.IHeaderResponseDecorator;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.jupiter.api.Test;

class ComponentsPageTest extends WicketTestCase {

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
            .forEach(ComponentsPageTest::assertHeaderItemExists);
    }

    static void assertHeaderItemExists(IReferenceHeaderItem headerItem) {
        ResourceReference.Key key = headerItem.getReference().getKey();

        assertTrue(PackageResource.exists(key), () -> "ResourceReference " + key + " should exist");
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
