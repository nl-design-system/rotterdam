package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;

import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.UTRECHT_FORM_LABEL_CHECKBOX;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.UTRECHT_FORM_LABEL_RADIO;

public enum UtrechtFormLabelType {
    CHECKBOX(UTRECHT_FORM_LABEL_CHECKBOX),
    RADIO(UTRECHT_FORM_LABEL_RADIO);

    final CssClassNames fullClassName;

    UtrechtFormLabelType(CssClassNames fullClassName) {
        this.fullClassName = fullClassName;
    }

}
