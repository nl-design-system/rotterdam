package nl.rotterdam.wicket.docs.logo_image;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_logo.RotterdamLogoImage;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class RotterdamLogoImageExamplesPanel extends ExamplesPanel {
    public RotterdamLogoImageExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RotterdamLogoImage.class;
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
