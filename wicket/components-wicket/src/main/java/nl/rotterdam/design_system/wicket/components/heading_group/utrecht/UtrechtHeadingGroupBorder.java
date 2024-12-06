package nl.rotterdam.design_system.wicket.components.heading_group.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtHeadingGroupBorder extends Border {

    public UtrechtHeadingGroupBorder(String id) {
        super(id);
        add(new UtrechtHeadingGroupBehavior());
    }
}
