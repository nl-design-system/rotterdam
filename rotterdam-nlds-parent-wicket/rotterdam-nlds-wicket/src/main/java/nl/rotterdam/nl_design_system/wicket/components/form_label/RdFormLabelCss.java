package nl.rotterdam.nl_design_system.wicket.components.form_label;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

public enum RdFormLabelCss implements CssClassNames {
    DEFAULT("utrecht-form-label"),
    FORM_LABEL_CHECKBOX("utrecht-form-label--checkbox"),
    FORM_LABEL_RADIO("utrecht-form-label--radio"),
    FORM_LABEL_STATE_DISABLED("utrecht-form-label--disabled");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    RdFormLabelCss(String classNames) {
        this.classNames = classNames;
    }
}
