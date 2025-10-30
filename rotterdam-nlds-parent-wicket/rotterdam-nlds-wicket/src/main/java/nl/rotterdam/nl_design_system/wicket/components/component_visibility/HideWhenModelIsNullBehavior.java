package nl.rotterdam.nl_design_system.wicket.components.component_visibility;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

public class HideWhenModelIsNullBehavior extends Behavior {

    public static final HideWhenModelIsNullBehavior INSTANCE = new HideWhenModelIsNullBehavior();

    private HideWhenModelIsNullBehavior() {}

    @Override
    public void onConfigure(Component component) {
        super.onConfigure(component);
        component.setVisible(component.getDefaultModelObject() != null);
    }
}
