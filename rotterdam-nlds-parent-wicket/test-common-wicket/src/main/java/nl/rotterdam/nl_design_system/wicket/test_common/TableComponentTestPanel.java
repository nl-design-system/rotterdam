package nl.rotterdam.nl_design_system.wicket.test_common;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class TableComponentTestPanel extends Panel {

    public TableComponentTestPanel(Component component) {
        super("static");
        add(component);
    }
}
