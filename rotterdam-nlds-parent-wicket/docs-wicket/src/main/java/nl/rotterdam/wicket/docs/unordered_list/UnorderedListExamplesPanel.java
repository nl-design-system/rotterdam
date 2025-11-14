package nl.rotterdam.wicket.docs.unordered_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.RdUnorderedListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.RdUnorderedListItemBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class UnorderedListExamplesPanel extends ExamplesPanel {

    public UnorderedListExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdUnorderedListItemBehavior.class;
    }

    @ComponentExample
    private static WebMarkupContainer exampleUnorderedList() {
        List<String> namen = List.of(
            "Binnen 5 werkdagen krijgt u een eerste bericht.",
            "Na uiterlijk 4 weken geeft de gemeente een inhoudelijke reactie."
        );

        return new WebMarkupContainer("unorderedListWebMarkupContainer") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(RdUnorderedListBehavior.INSTANCE);
                add(
                    new ListView<>("listItem", namen) {
                        @Override
                        protected void populateItem(ListItem<String> item) {
                            item.add(RdUnorderedListItemBehavior.INSTANCE);
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
