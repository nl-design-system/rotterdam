package nl.rotterdam.nl_design_system.wicket.test_common;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class DlComponentTestPanel extends Panel {

    public DlComponentTestPanel(Component component) {
        super("static");
        add(component);
    }
}
