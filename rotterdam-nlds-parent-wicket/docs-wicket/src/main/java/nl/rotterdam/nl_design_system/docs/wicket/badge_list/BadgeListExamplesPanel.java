package nl.rotterdam.nl_design_system.docs.wicket.badge_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.badge_list.RdBadgeListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.data_badge.RdDataBadgeBehavior;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class BadgeListExamplesPanel extends ExamplesPanel {
    public BadgeListExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdBadgeListBehavior.class;
    }

    @ComponentExample
    private static WebMarkupContainer exampleBadgeList() {
        List<String> namen = List.of("duurzaamheid", "schoon, heel en veilig");

        return new WebMarkupContainer("badgeList") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new RdBadgeListBehavior()); // TODO should be singleton
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(new RdDataBadgeBehavior()); // TODO: should be singleton
                            String naam = item.getModelObject();
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
