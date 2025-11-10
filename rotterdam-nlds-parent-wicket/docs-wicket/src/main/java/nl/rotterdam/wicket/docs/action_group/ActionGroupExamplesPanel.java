package nl.rotterdam.wicket.docs.action_group;

import nl.rotterdam.nl_design_system.wicket.components.action_group.RdActionGroup;
import nl.rotterdam.nl_design_system.wicket.components.button.RdButton;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class ActionGroupExamplesPanel extends ExamplesPanel {
    public ActionGroupExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdActionGroup.class;
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
