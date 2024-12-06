package nl.rotterdam.design_system.wicket.components.page_body.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageBodyBorder extends Border {

    public UtrechtPageBodyBorder(String id) {
        super(id);
        add(new UtrechtPageBodyBehavior());
    }
}
