package nl.rotterdam.design_system.wicket.components.page_layout.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageLayoutBorder extends Border {

    public UtrechtPageLayoutBorder(String id) {
        super(id);
        add(new UtrechtPageLayoutBehavior());
    }
}
