package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtFormLabel extends Panel {

    public static final String SLOT_ID = "slot";
    private final Label label;

    public UtrechtFormLabel(String id, IModel<?> textContent) {
        super(id);
        label = new Label(SLOT_ID, textContent);
        add(label);
    }
}
