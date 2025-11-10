package nl.rotterdam.nl_design_system.wicket.components.form_label;

import static nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelCss.FORM_LABEL_CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelCss.FORM_LABEL_RADIO;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

public enum RdFormLabelType {
    CHECKBOX(FORM_LABEL_CHECKBOX),
    RADIO(FORM_LABEL_RADIO);

    final CssClassNames fullClassName;

    RdFormLabelType(CssClassNames fullClassName) {
        this.fullClassName = fullClassName;
    }
}
