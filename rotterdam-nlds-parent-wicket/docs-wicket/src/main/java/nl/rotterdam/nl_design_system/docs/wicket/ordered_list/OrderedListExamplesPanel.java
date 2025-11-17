package nl.rotterdam.nl_design_system.docs.wicket.ordered_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.ordered_list.RdOrderedListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.ordered_list.RdOrderedListItemBehavior;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class OrderedListExamplesPanel extends ExamplesPanel {
    public OrderedListExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdOrderedListItemBehavior.class;
    }

    @ComponentExample
    private static WebMarkupContainer exampleOrderedList() {
        List<String> namen = List.of("Adam", "Noah", "Mohammed", "Zayn", "James");

        return new WebMarkupContainer("orderedListWebMarkupContainer") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new RdOrderedListBehavior()); // TODO should be singleton
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(new RdOrderedListItemBehavior()); // TODO: should be singleton
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

        add(exampleOrderedList());
    }
}
