package nl.rotterdam.wicket.docs.icon;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.RdUnorderedListBehavior;
import nl.rotterdam.nl_design_system.wicket.components.unordered_list.RdUnorderedListItemBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.Arrays;
import java.util.List;

public class RodsIconExamplesPanel extends ExamplesPanel {

    public RodsIconExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RotterdamIconBehavior.class;
    }

    @ComponentExample
    private static Component exampleRodsIcons() {
        List<RotterdamIconType> icons = Arrays.asList(RotterdamIconType.values());

        return new WebMarkupContainer("rodsIconset") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new RdUnorderedListBehavior());
                add(
                    new ListView<>("iconItem", icons) {
                        @Override
                        protected void populateItem(ListItem<RotterdamIconType> item) {
                            item.add(new RdUnorderedListItemBehavior()); // TODO: should be singleton
                            RotterdamIconType iconType = item.getModelObject();
                            WebMarkupContainer icon = new WebMarkupContainer("icon");
                            icon.add(new RotterdamIconBehavior(iconType));
                            item.add(icon);

                            item.add(
                                new Label("label", "RotterdamIconType." + iconType.type.toUpperCase().replace("-", "_"))
                            );
                        }
                    }
                );
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleRodsIcons());
    }
}
