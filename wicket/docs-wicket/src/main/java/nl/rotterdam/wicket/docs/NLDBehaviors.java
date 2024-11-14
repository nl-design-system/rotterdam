package nl.rotterdam.wicket.docs;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

public class NLDBehaviors {

    public static Behavior heading1() {
        return new Behavior() {

            @Override
            public void onConfigure(Component component) {
                super.onConfigure(component);

                // TODO: do this only once per component
                component.add(AttributeModifier.append("class", "utrecht-heading-1"));
            }
        };
    }
}
