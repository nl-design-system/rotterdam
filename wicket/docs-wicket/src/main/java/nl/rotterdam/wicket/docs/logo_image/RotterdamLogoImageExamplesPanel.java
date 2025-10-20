package nl.rotterdam.wicket.docs.logo_image;

import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class RotterdamLogoImageExamplesPanel extends Panel {

    public RotterdamLogoImageExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static RotterdamLogoImage exampleLogoImage() {
        return new RotterdamLogoImage("rotterdamLogoImage");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLogoImage());
    }
}
