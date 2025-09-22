package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

public enum UtrechtFormFieldCss implements CssClassNames {

    DEFAULT("utrecht-form-field"),
    INVALID("utrecht-form-field--invalid"),
    FORM_FIELD_NESTED_BLOCK_INPUT("utrecht-form-field__input"),
    FORM_FIELD_NESTED_BLOCK_DESCRIPTION("utrecht-form-field__description"),
    FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE("utrecht-form-field__error-message"),
    FORM_FIELD_NESTED_BLOCK_LABEL("utrecht-form-field__label");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormFieldCss(String classNames) {
        this.classNames = classNames;
    }

}
