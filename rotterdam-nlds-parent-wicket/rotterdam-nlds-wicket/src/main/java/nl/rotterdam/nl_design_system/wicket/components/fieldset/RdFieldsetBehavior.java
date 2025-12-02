package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdFieldsetBehavior extends TagNameClassComponentBehavior<RdFieldset> {
    private static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdFieldsetBehavior.class,
        "@utrecht/form-fieldset-css/dist/index.min.css"
    );
    
    static final RdFieldsetBehavior INSTANCE = new RdFieldsetBehavior();

    private RdFieldsetBehavior() {
        super("div", RdFieldsetCss.BASE);
        addHeaderItem(CSS_HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdFieldset component, ComponentTag tag) {
        var classNamesList = new ArrayList<CssClassNames>(2);
        if (component.isInvalid()) {
            classNamesList.add(RdFieldsetCss.INVALID);
        }
        if (component.isSection()) {
            classNamesList.add(RdFieldsetCss.SECTION);
        }
        return classNamesList;
    }
}
