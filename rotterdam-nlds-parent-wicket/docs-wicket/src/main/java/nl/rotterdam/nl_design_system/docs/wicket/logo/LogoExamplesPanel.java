package nl.rotterdam.nl_design_system.docs.wicket.logo;

import nl.rotterdam.nl_design_system.wicket.components.logo.RdLogoBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class LogoExamplesPanel extends ExamplesPanel {
    public LogoExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdLogoBorder.class;
    }

    @ComponentExample
    private static RdLogoBorder exampleLogo() {
        return new RdLogoBorder("logo");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLogo());
    }
}
