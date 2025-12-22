package nl.rotterdam.nl_design_system.docs.wicket.code;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.code.RdCodeBorder;

public class CodeExamplesPanel extends ExamplesPanel {
    public CodeExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdCodeBorder.class;
    }

    @ComponentExample
    private static RdCodeBorder exampleCode() {
        return new RdCodeBorder("code");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleCode());
    }
}
