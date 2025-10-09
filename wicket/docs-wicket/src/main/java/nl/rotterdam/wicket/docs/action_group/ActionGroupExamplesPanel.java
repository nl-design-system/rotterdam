package nl.rotterdam.wicket.docs.action_group;

import nl.rotterdam.design_system.wicket.components.button.RdButton;
import nl.rotterdam.design_system.wicket.components.action_group.RdActionGroup;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class ActionGroupExamplesPanel extends Panel {

    public ActionGroupExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleActionGroup() {
        return new RdActionGroup("actionGroup")
            .add(new RdButton("button") {
                @Override
                public void onSubmit() {
                    super.onSubmit();
                    System.out.println("ActionGroupExamplesPanel.onSubmit called");
                }
            });
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleActionGroup());
    }
}
