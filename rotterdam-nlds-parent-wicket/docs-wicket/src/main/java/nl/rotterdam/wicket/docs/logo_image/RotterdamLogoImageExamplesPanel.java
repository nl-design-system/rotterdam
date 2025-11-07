package nl.rotterdam.wicket.docs.logo_image;

import nl.rotterdam.nl_design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class RotterdamLogoImageExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = RotterdamLogoImage.class;

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
