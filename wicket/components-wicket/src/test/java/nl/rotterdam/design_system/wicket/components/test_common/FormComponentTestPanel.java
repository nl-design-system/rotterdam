package nl.rotterdam.design_system.wicket.components.test_common;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class FormComponentTestPanel extends Panel {

    public FormComponentTestPanel(Component component) {
        super("static");

        add(component);
    }
}
