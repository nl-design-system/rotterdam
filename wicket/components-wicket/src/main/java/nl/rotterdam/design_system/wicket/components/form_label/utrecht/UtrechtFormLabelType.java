package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClassNames.UTRECHT_FORM_LABEL_CHECKBOX_CLASS_NAME;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClassNames.UTRECHT_FORM_LABEL_RADIO_CLASS_NAME;

public enum UtrechtFormLabelType {
    CHECKBOX(UTRECHT_FORM_LABEL_CHECKBOX_CLASS_NAME),
    RADIO(UTRECHT_FORM_LABEL_RADIO_CLASS_NAME);

    final String fullClassName;

    UtrechtFormLabelType(String fullClassName) {
        this.fullClassName = fullClassName;
    }

}
