package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtFormFieldTextboxCss implements CssClassNames {

    UTRECHT_FORM_FIELD_TEXT("utrecht-form-field--text");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormFieldTextboxCss(String classNames) {
        this.classNames = classNames;
    }
}
