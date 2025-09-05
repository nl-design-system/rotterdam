package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtFormLabel extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtFormLabel(String id, IModel<?> textContent) {
        super(id);
        add(new UtrechtFormLabelBehavior());
        add(new Label(SLOT_ID, textContent));
    }

    public UtrechtFormLabel(String id, IModel<?> textContent, UtrechtFormLabelType type) {
        super(id);
        add(new UtrechtFormLabelBehavior(type));
        add(new Label(SLOT_ID, textContent));
    }
}
