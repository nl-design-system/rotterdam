package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldContainerBehavior extends TagNameClassComponentBehavior {

    private static final String FORM_FIELD_CHECKBOX_CLASSNAME = "utrecht-form-field--checkbox";

    public static final UtrechtFormFieldContainerBehavior INSTANCE_TEXT = new UtrechtFormFieldContainerBehavior();

    public static final UtrechtFormFieldContainerBehavior INSTANCE_CHECKBOX = new UtrechtFormFieldContainerBehavior(FORM_FIELD_CHECKBOX_CLASSNAME);

    private UtrechtFormFieldContainerBehavior(String inputTypeSpecificClassName) {
        super("div", "utrecht-form-field", inputTypeSpecificClassName);
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldContainerBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }


    private UtrechtFormFieldContainerBehavior() {
        super("div", "utrecht-form-field");
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldContainerBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }
}
