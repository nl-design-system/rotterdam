package nl.rotterdam.nl_design_system.wicket.components.body;

import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

public class RdBodyTransparentContainer extends TransparentWebMarkupContainer {
    public RdBodyTransparentContainer(String id) {
        super(id);
        add(RdBodyBehavior.INSTANCE);
    }
}
