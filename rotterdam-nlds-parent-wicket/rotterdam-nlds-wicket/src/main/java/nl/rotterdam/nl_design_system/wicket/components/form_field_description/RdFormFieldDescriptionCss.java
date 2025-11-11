package nl.rotterdam.nl_design_system.wicket.components.form_field_description;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdFormFieldDescriptionCss implements CssClassNames {
    DEFAULT("utrecht-form-field-description");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    RdFormFieldDescriptionCss(String classNames) {
        this.classNames = classNames;
    }
}
