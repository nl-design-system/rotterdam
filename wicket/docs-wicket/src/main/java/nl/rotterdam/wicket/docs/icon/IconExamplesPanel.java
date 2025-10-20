package nl.rotterdam.wicket.docs.icon;

import nl.rotterdam.design_system.wicket.components.icon.utrecht.UtrechtIconBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class IconExamplesPanel extends Panel {

    public IconExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtIconBorder exampleIconComponent() {
        return new UtrechtIconBorder("icon");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleIconComponent());
    }
}
