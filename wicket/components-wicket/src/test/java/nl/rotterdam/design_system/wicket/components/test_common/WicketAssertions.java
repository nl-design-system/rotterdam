package nl.rotterdam.design_system.wicket.components.test_common;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.request.resource.ResourceReference;

import static org.junit.jupiter.api.Assertions.assertTrue;

public enum WicketAssertions {
    ;

    public static void assertHeaderItemExists(CssReferenceHeaderItem headerItem) {
        ResourceReference.Key key = headerItem.getReference().getKey();

        assertTrue(PackageResource.exists(key), () -> "ResourceReference " + key + " should exist");
    }
}
