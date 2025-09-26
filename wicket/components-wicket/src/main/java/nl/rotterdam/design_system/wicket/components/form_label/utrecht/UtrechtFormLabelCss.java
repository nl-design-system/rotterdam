package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

public enum UtrechtFormLabelCss implements CssClassNames {

    DEFAULT("utrecht-form-label"),
    UTRECHT_FORM_LABEL_CHECKBOX("utrecht-form-label--checkbox"),
    UTRECHT_FORM_LABEL_RADIO("utrecht-form-label--radio"),
    FORM_LABEL_STATE_DISABLED("utrecht-form-label--disabled");
    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormLabelCss(String classNames) {
        this.classNames = classNames;
    }

}
