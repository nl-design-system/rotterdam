package nl.rotterdam.nl_design_system.wicket.components.badge_list;

import org.apache.wicket.markup.html.border.Border;

public class RdBadgeListBorder extends Border {

    public RdBadgeListBorder(String id) {
        super(id);
        add(new RdBadgeListBehavior());
    }
}
