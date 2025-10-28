package nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.UTRECHT_FORM_LABEL_CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.UTRECHT_FORM_LABEL_RADIO;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

public enum UtrechtFormLabelType {
    CHECKBOX(UTRECHT_FORM_LABEL_CHECKBOX),
    RADIO(UTRECHT_FORM_LABEL_RADIO);

    final CssClassNames fullClassName;

    UtrechtFormLabelType(CssClassNames fullClassName) {
        this.fullClassName = fullClassName;
    }
}
