package nl.rotterdam.wicket.docs.logo;

import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtLogoExamplesPanel extends Panel {

    public UtrechtLogoExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleLogo() {
        return new UtrechtLogoBorder("utrechtLogo");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLogo());
    }
}
