package nl.rotterdam.wicket.docs.ordered_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.ordered_list.utrecht.UtrechtOrderedListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.ordered_list.utrecht.UtrechtOrderedListItemBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class OrderedListExamplesPanel extends Panel {

    public OrderedListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static WebMarkupContainer exampleOrderedList() {
        List<String> namen = List.of("Adam", "Noah", "Mohammed", "Zayn", "James");

        return new WebMarkupContainer("orderedListWebMarkupContainer") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new UtrechtOrderedListBehavior()); // TODO should be singleton
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(new UtrechtOrderedListItemBehavior()); // TODO: should be singleton
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
