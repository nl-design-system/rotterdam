package nl.rotterdam.design_system.wicket.components.test_common;

import org.apache.wicket.markup.html.panel.Panel;

public class FormComponentTestPanel extends Panel {

    public FormComponentTestPanel(Panel component) {
        super("static");

        add(component);
    }
}
