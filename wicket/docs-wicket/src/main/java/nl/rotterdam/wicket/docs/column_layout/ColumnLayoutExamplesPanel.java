package nl.rotterdam.wicket.docs.column_layout;

import nl.rotterdam.design_system.wicket.components.column_layout.utrecht.UtrechtColumnLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class ColumnLayoutExamplesPanel extends Panel {

    public ColumnLayoutExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleColumnLayout() {
        return new UtrechtColumnLayoutBorder("columnLayout");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleColumnLayout());
    }
}
