package nl.rotterdam.nl_design_system.wicket.components;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

/**
 * Utility methods for CSS Resource references
 */
public class CssReferenceHeaderItems {

    /**
     * Creates new reference header item in a shorter way
     * @param scope Class which defines the package of the resource
     * @param name css filename
     * @return Resource Reference.
     */
    public static CssReferenceHeaderItem cssReferenceHeaderItem(Class<?> scope, String name) {
        return CssReferenceHeaderItem.forReference(new CssResourceReference(scope, name));
    }
}
