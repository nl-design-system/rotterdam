package nl.rotterdam.design_system.wicket.components.body.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtBodyBorder extends Border {

    public UtrechtBodyBorder(String id) {
        super(id);
        add(new UtrechtBodyBehavior());
    }
}
