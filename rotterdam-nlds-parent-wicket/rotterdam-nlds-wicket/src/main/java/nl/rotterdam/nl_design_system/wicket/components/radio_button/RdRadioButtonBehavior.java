package nl.rotterdam.nl_design_system.wicket.components.radio_button;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdRadioButtonBehavior extends TagNameClassComponentBehavior<RdRadioButton<?>> {
    private static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdRadioButtonBehavior.class,
        "@utrecht/radio-button-css/dist/index.min.css"
    );

    static final RdRadioButtonBehavior INSTANCE = new RdRadioButtonBehavior();

    public RdRadioButtonBehavior() {
        super("input", RdRadioButtonCss.BASE, RdRadioButtonCss.HTML_INPUT);
        addHeaderItem(CSS_HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdRadioButton<?> component, ComponentTag tag) {
        var classNames = new ArrayList<CssClassNames>(2);
        
        if (!component.isEnabled()) {
            classNames.add(RdRadioButtonCss.DISABLED);
        }

        // Errors will normally be set on the radio group. Support it anyway in case an error on a specific radio button
        // is needed in some situation.
        if (component.hasErrorMessage()) {
            classNames.add(RdRadioButtonCss.INVALID);
            tag.put("aria-invalid", "true");
        }
        
        return classNames;
    }
}
