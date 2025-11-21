package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.alert.AlertExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.body.BodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.button.ButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon_button.IconButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.side_nav.SideNavExamplesPanel;

import java.util.List;

public class ComponentExamplePanels {

    // TODO add all classes, for now just a subset.
    public static final List<Class<? extends ExamplesPanel>> classes = List.of(
        SideNavExamplesPanel.class,
        AlertExamplesPanel.class,
        BadgeListExamplesPanel.class,
        BodyExamplesPanel.class,
        ButtonExamplesPanel.class,
        IconButtonExamplesPanel.class,
        ActionGroupExamplesPanel.class
    );

}
