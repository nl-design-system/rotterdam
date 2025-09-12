package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtCheckboxBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtCheckboxBehavior INSTANCE = new UtrechtCheckboxBehavior();
    private UtrechtCheckboxBehavior() {
        // TODO: move css pats of UtrechtFormFieldContainerBehavior to here
        super("input");

        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxBehavior.class, "@utrecht/checkbox-css/dist/index.css"));
        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxBehavior.class, "@utrecht/custom-checkbox-css/dist/index.css"));

    }
}
