package nl.rotterdam.nl_design_system.wicket.components.form_field_label;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

/**
 * <p>
 * The type of checkable input that the label is for.
 * </p>
 */
public enum RdFormFieldLabelCheckableInputType {
    /**
     * <p>
     * The label is for a checkbox.
     * </p>
     */
    CHECKBOX(RdFormFieldLabelCss.CHECKBOX),
    /**
     * <p>
     * The label is for a radio button.
     * </p>
     */
    RADIO_BUTTON(RdFormFieldLabelCss.RADIO);

    final CssClassNames classNames;

    RdFormFieldLabelCheckableInputType(CssClassNames classNames) {
        this.classNames = classNames;
    }
}
