package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtBadgeListBorder extends Border {

    public UtrechtBadgeListBorder(String id) {
        super(id);
        add(new UtrechtBadgeListBehavior());
    }
}
