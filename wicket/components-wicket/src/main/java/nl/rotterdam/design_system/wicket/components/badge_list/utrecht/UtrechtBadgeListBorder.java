package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import org.apache.wicket.markup.html.border.Border;


// TODO utrecht-badge-list will be added twice
@Deprecated
public class UtrechtBadgeListBorder extends Border {

    public UtrechtBadgeListBorder(String id) {
        super(id);
        add(UtrechtBadgeListBehavior.INSTANCE);
    }
}
