package nl.rotterdam.nl_design_system.docs.wicket.heading_group;

import nl.rotterdam.nl_design_system.wicket.components.heading_group.RdHeadingGroupBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class HeadingGroupExamplesPanel extends ExamplesPanel {
    public HeadingGroupExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdHeadingGroupBorder.class;
    }

    @ComponentExample
    private static RdHeadingGroupBorder exampleHeadingGroup() {
        return new RdHeadingGroupBorder("headingGroup");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHeadingGroup());
    }
}
