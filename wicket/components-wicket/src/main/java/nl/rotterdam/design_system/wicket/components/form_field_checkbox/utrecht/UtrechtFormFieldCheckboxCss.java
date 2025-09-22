package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtFormFieldCheckboxCss implements CssClassNames {

    UTRECHT_FORM_FIELD_CHECKBOX("utrecht-form-field--checkbox"),
    UTRECHT_FORM_FIELD_LABEL_CHECKBOX("utrecht-form-field__label--checkbox");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormFieldCheckboxCss(String classNames) {
        this.classNames = classNames;
    }

}
