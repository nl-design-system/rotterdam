package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import java.util.List;
import nl.rotterdam.design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

public class UtrechtLinkListPanel extends Panel {

    public List<UtrechtLinkListRecord<? extends IRequestablePage>> links;

    public UtrechtLinkListPanel(String id, List<UtrechtLinkListRecord<? extends IRequestablePage>> links) {
        super(id);
        this.links = links;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<UtrechtLinkListRecord<? extends IRequestablePage>> links = this.links;

        add(
            new WebMarkupContainer("utrechtLinkList") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();

                    add(new UtrechtLinkListBehavior()); // TODO should be singleton
                    add(
                        new ListView<UtrechtLinkListRecord<? extends IRequestablePage>>("utrechtLinkListItem", links) {
                            @Override
                            protected void populateItem(
                                ListItem<UtrechtLinkListRecord<? extends IRequestablePage>> item
                            ) {
                                item.add(new UtrechtLinkListItemBehavior()); // TODO: should be singleton
                                UtrechtLinkListRecord<? extends IRequestablePage> record = item.getModelObject();
                                String naam = record.label();

                                // TODO: How do I type this?
                                @SuppressWarnings({ "rawtypes", "unchecked" })
                                UtrechtLinkListLink<?> link = new UtrechtLinkListLink(
                                    "utrechtLinkListLink",
                                    record.target()
                                );

                                // Optionally add an icon
                                if (record.icon() != null) {
                                    WebMarkupContainer icon = new WebMarkupContainer("utrechtLinkListLinkIcon");
                                    icon.add(new RotterdamIconBehavior(record.icon()));
                                    link.add(icon);
                                } else {
                                    WebMarkupContainer icon = new WebMarkupContainer("utrechtLinkListLinkIcon");
                                    icon.add(new RotterdamIconBehavior(RotterdamIconType.CHEVRON_RIGHT));
                                    link.add(icon);
                                }

                                // Add the link text
                                link.add(new Label("utrechtLinkListLinkLabel", naam));

                                item.add(link);
                            }
                        }
                    );
                }
            }
        );
    }
}
