package nl.rotterdam.wicket.docs.unordered_list;

import java.util.List;
import nl.rotterdam.design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedListBehavior;
import nl.rotterdam.design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedListItemBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtUnorderedListExamplesPanel extends Panel {

    public UtrechtUnorderedListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleUnorderedList() {
        List<String> namen = List.of(
            "Binnen 5 werkdagen krijgt u een eerste bericht.",
            "Na uiterlijk 4 weken geeft de gemeente een inhoudelijke reactie."
        );

        return new WebMarkupContainer("utrechtUnorderedListWebMarkupContainer") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new UtrechtUnorderedListBehavior()); // TODO should be singleton
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(new UtrechtUnorderedListItemBehavior()); // TODO: should be singleton
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

        add(exampleUnorderedList());
    }
}
