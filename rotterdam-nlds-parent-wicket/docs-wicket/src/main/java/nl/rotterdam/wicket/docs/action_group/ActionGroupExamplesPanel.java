package nl.rotterdam.wicket.docs.action_group;

import nl.rotterdam.nl_design_system.wicket.components.action_group.RdActionGroup;
import nl.rotterdam.nl_design_system.wicket.components.button.RdButton;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class ActionGroupExamplesPanel extends Panel {

    public ActionGroupExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static RdActionGroup exampleActionGroup() {
        RdActionGroup component = new RdActionGroup("actionGroup");
        component.add(
            new RdButton("button") {
                @Override
                public void onSubmit() {
                    super.onSubmit();
                    System.out.println("ActionGroupExamplesPanel.onSubmit called");
                }
            }
        );
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleActionGroup());
    }
}
