package nl.rotterdam.wicket.docs.icon;

import java.util.Arrays;
import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedListItemBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class RodsIconExamplesPanel extends Panel {

    public RodsIconExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleRodsIcons() {
        // List<RotterdamIconType> links = Arrays.asList(RotterdamIconType.values());
        List<RotterdamIconType> icons = Arrays.asList(RotterdamIconType.values());
        // List<RotterdamIconType> icons = List.of(RotterdamIconType.TRASH);

        return new WebMarkupContainer("rodsIconset") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new UtrechtUnorderedListBehavior());
                add(
                    new ListView<>("iconItem", icons) {
                        @Override
                        protected void populateItem(ListItem<RotterdamIconType> item) {
                            item.add(new UtrechtUnorderedListItemBehavior()); // TODO: should be singleton
                            RotterdamIconType iconType = item.getModelObject();
                            // item.add(naam);
                            // item.add(new RotterdamIconBehavior(iconType))
                            WebMarkupContainer icon = new WebMarkupContainer("icon");
                            icon.add(new RotterdamIconBehavior(iconType));
                            item.add(icon);

                            item.add(
                                new Label("label", "RotterdamIconType." + iconType.type.toUpperCase().replace("-", "_"))
                            );
                        }
                    }
                );
                /*
                    new ListView<RotterdamIconType>("iconItem", icons) {
                        @Override
                        protected void populateItem(ListItem<RotterdamIconType> item) {
                            RotterdamIconType iconType = item.getModelObject();

                            // WebMarkupContainer icon = new WebMarkupContainer("icon");
                            // icon.add(new RotterdamIconBehavior(iconType));

                            // WebMarkupContainer iconLabel = new WebMarkupContainer("iconLabel");
                            // iconLabel.add(new Label(iconType.type));

                            // item.add(iconLabel);
                            // item.add(icon);
                            item.add(new Label(iconType.type));
                        }
                    }
                ); */
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleRodsIcons());
    }
}
