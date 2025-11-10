package nl.rotterdam.wicket.docs.heading_group;

import nl.rotterdam.nl_design_system.wicket.components.heading_group.utrecht.UtrechtHeadingGroupBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class HeadingGroupExamplesPanel extends ExamplesPanel {
    public HeadingGroupExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtHeadingGroupBorder.class;
    }

    @ComponentExample
    private static UtrechtHeadingGroupBorder exampleHeadingGroup() {
        return new UtrechtHeadingGroupBorder("headingGroup");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHeadingGroup());
    }
}
