package nl.rotterdam.wicket.docs.button_group;

import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class ButtonGroupExamplesPanel extends Panel {

    public ButtonGroupExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleButtonGroup() {
        return new UtrechtButtonGroupBorder("utrechtButtonGroup");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleButtonGroup());
    }
}
