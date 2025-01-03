package nl.rotterdam.wicket.docs.heading_group;

import nl.rotterdam.design_system.wicket.components.heading_group.utrecht.UtrechtHeadingGroupBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class HeadingGroupExamplesPanel extends Panel {

    public HeadingGroupExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleHeadingGroup() {
        return new UtrechtHeadingGroupBorder("utrechtHeadingGroup");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHeadingGroup());
    }
}
