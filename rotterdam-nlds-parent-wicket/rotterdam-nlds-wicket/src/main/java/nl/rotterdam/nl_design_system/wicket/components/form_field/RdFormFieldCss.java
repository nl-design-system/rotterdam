package nl.rotterdam.nl_design_system.wicket.components.form_field;

import nl.rotterdam.nl_design_system.wicket.components.component_state.Community;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

/**
 * It has public visibility, can be used by library users, d should only be used for Form Fields implemented by
 * {@link Community} Utrecht.
 */
@SuppressWarnings("doclint:missing")
public enum RdFormFieldCss implements CssClassNames {
    BASE("utrecht-form-field"),
    DESCRIPTION_ELEMENT("utrecht-form-field__description"),
    ERROR_MESSAGE_ELEMENT("utrecht-form-field__error-message"),
    INPUT_ELEMENT("utrecht-form-field__input"),
    INVALID("utrecht-form-field--invalid"),
    LABEL_ELEMENT("utrecht-form-field__label");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldCss(String classNames) {
        this.classNames = classNames;
    }
}
