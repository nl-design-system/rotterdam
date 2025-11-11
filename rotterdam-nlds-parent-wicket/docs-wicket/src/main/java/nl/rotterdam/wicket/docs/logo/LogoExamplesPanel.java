package nl.rotterdam.wicket.docs.logo;

import nl.rotterdam.nl_design_system.wicket.components.logo.RdLogoBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

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
