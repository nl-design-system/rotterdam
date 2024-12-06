package nl.rotterdam.design_system.wicket.components.column_layout.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtColumnLayoutBorder extends Border {

    public UtrechtColumnLayoutBorder(String id) {
        super(id);
        add(new UtrechtColumnLayoutBehavior());
    }
}
