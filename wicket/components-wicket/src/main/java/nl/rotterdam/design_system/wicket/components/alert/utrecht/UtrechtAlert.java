package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtAlert extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtAlert(String id, IModel<String> textContent, UtrechtAlertType type) {
        super(id);
        add(UtrechtAlertBehavior.utrechtAlert(type));
        add(new Label(SLOT_ID, textContent));
    }
}
