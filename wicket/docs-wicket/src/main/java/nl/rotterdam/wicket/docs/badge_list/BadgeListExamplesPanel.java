package nl.rotterdam.wicket.docs.badge_list;

import nl.rotterdam.design_system.wicket.components.badge_list.utrecht.UtrechtBadgeListBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class BadgeListExamplesPanel extends Panel {

    public BadgeListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleBadgeList() {
        return new UtrechtBadgeListBorder("utrechtBadgeList");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleBadgeList());
    }
}
