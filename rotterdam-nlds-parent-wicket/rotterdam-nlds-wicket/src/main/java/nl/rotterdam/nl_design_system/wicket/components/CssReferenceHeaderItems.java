package nl.rotterdam.nl_design_system.wicket.components;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class CssReferenceHeaderItems {

    public static CssReferenceHeaderItem cssReferenceHeaderItem(Class<?> scope, String name) {
        return CssReferenceHeaderItem.forReference(new CssResourceReference(scope, name));
    }
}
