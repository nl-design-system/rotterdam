package nl.rotterdam.nl_design_system.wicket.test_common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.wicket.markup.head.IReferenceHeaderItem;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.request.resource.ResourceReference;

public enum WicketAssertions {
    ;

    public static void assertHeaderItemExists(IReferenceHeaderItem headerItem) {
        ResourceReference.Key key = headerItem.getReference().getKey();

        assertTrue(PackageResource.exists(key), () -> "ResourceReference " + key + " should exist");
    }
}
