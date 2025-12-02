package nl.rotterdam.nl_design_system.wicket.components.form_fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdFormFieldsetBehavior extends TagNameClassComponentBehavior<RdFormFieldset> {
    private static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdFormFieldsetBehavior.class,
        "@utrecht/form-fieldset-css/dist/index.min.css"
    );
    
    static final RdFormFieldsetBehavior INSTANCE = new RdFormFieldsetBehavior();

    private RdFormFieldsetBehavior() {
        super("div", RdFormFieldsetCss.BASE);
        addHeaderItem(CSS_HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdFormFieldset component, ComponentTag tag) {
        var classNamesList = new ArrayList<CssClassNames>(2);
        if (component.isInvalid()) {
            classNamesList.add(RdFormFieldsetCss.INVALID);
        }
        if (component.isSection()) {
            classNamesList.add(RdFormFieldsetCss.SECTION);
        }
        return classNamesList;
    }
}
