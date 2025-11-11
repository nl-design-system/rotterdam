package nl.rotterdam.nl_design_system.wicket.components.body;

import org.apache.wicket.markup.html.border.Border;

public class RdBodyBorder extends Border {

    public RdBodyBorder(String id) {
        super(id);
        add(RdBodyBehavior.INSTANCE);
    }
}
