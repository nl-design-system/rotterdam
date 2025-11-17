package nl.rotterdam.nl_design_system.docs.wicket.logo_image;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_logo.RotterdamLogoImage;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

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
