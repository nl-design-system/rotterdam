package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public class UtrechtAlert extends GenericPanel<String> {

    private static final String MESSAGE_ID = "message";

    public UtrechtAlert(String id, IModel<String> model, UtrechtAlertType type) {
        super(id, model);
        add(UtrechtAlertBehavior.utrechtAlert(type));
        add(new Label(MESSAGE_ID, model));
    }
}
