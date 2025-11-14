package nl.rotterdam.nl_design_system.wicket.components.link_list;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListBehavior.INSTANCE;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

/**
 * <a href="https://nldesignsystem.nl/link-list/">NL Design System Link List component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdLinkListPanel extends Panel {

    private final List<RdLinkListRecord<? extends IRequestablePage>> links;

    /**
     * Creates instance
     * @param id the Wicket ID
     * @param links links to show
     *              TODO use Model
     */
    public RdLinkListPanel(String id, List<RdLinkListRecord<? extends IRequestablePage>> links) {
        super(id);
        this.links = links;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<RdLinkListRecord<? extends IRequestablePage>> links = this.links;

        add(
            new WebMarkupContainer("linkList") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();

                    add(INSTANCE);
                    add(
                        new ListView<>("linkListItem", links) {
                            @Override
                            protected void populateItem(
                                ListItem<RdLinkListRecord<? extends IRequestablePage>> item
                            ) {
                                item.add(RdLinkListItemBehavior.INSTANCE);
                                RdLinkListRecord<? extends IRequestablePage> record = item.getModelObject();
                                String naam = record.label();

                                // TODO: How do I type this?
                                @SuppressWarnings({ "rawtypes", "unchecked" })
                                RdLinkListLink<?> link = new RdLinkListLink(
                                    "linkListLink",
                                    record.target()
                                );

                                // Optionally add an icon
                                if (record.icon() != null) {
                                    WebMarkupContainer icon = new WebMarkupContainer("linkListLinkIcon");
                                    icon.add(new RotterdamIconBehavior(record.icon()));
                                    link.add(icon);
                                } else {
                                    WebMarkupContainer icon = new WebMarkupContainer("linkListLinkIcon");
                                    icon.add(new RotterdamIconBehavior(RotterdamIconType.CHEVRON_RIGHT));
                                    link.add(icon);
                                }

                                // Add the link text
                                link.add(new Label("linkListLinkLabel", naam));

                                item.add(link);
                            }
                        }
                    );
                }
            }
        );
    }
}
