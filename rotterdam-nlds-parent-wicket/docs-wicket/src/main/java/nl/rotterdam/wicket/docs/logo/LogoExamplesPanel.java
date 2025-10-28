package nl.rotterdam.wicket.docs.logo;

import nl.rotterdam.nl_design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class LogoExamplesPanel extends Panel {

    public LogoExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtLogoBorder exampleLogo() {
        return new UtrechtLogoBorder("logo");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLogo());
    }
}
