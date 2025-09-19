package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.UTRECHT_FORM_LABEL_CHECKBOX;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.UTRECHT_FORM_LABEL_RADIO;

public enum UtrechtFormLabelType {
    CHECKBOX(UTRECHT_FORM_LABEL_CHECKBOX),
    RADIO(UTRECHT_FORM_LABEL_RADIO);

    final String fullClassName;

    UtrechtFormLabelType(String fullClassName) {
        this.fullClassName = fullClassName;
    }

}
