package nl.rotterdam.wicket.docs.badge_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.badge_list.utrecht.UtrechtBadgeListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.data_badge.utrecht.UtrechtDataBadgeBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class BadgeListExamplesPanel extends Panel {

    public BadgeListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static WebMarkupContainer exampleBadgeList() {
        List<String> namen = List.of("duurzaamheid", "schoon, heel en veilig");

        return new WebMarkupContainer("badgeList") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new UtrechtBadgeListBehavior()); // TODO should be singleton
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(new UtrechtDataBadgeBehavior()); // TODO: should be singleton
                            String naam = item.getModelObject();
                            // item.add(naam);
                            item.add(new Label("label", naam));
                        }
                    }
                );
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleBadgeList());
    }
}
