package nl.rotterdam.wicket.docs.column_layout;

import nl.rotterdam.nl_design_system.wicket.components.column_layout.RdColumnLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class ColumnLayoutExamplesPanel extends ExamplesPanel {
    public ColumnLayoutExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdColumnLayoutBorder.class;
    }

    @ComponentExample
    private static RdColumnLayoutBorder exampleColumnLayout() {
        return new RdColumnLayoutBorder("columnLayout");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleColumnLayout());
    }
}
