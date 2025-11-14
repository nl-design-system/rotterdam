package nl.rotterdam.nl_design_system.wicket.components.link_list;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListBehavior.INSTANCE;

import java.util.List;
import java.util.function.Supplier;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.behavior.Behavior;
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
    private final Supplier<Behavior> defautlIconBehaviorSupplier;

    /**
     * Creates instance
     * @param id the Wicket ID
     * @param links links to show
     *              TODO use Model
     */
    public RdLinkListPanel(String id, List<RdLinkListRecord<? extends IRequestablePage>> links, Supplier<Behavior> defautlIconBehaviorSupplier) {
        super(id);
        this.links = links;
        this.defautlIconBehaviorSupplier = defautlIconBehaviorSupplier;
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
                                var label = record.label();

                                @SuppressWarnings({ "rawtypes", "unchecked" })
                                RdLinkListLink<?> link = new RdLinkListLink(
                                    "linkListLink",
                                    record.target()
                                );

                                // Optionally add an icon
                                WebMarkupContainer icon = new WebMarkupContainer("linkListLinkIcon");
                                link.add(icon);
                                if (record.iconBehaviorSupplier() != null) {
                                    icon.add(record.iconBehaviorSupplier().get());
                                } else {
                                    icon.add(defautlIconBehaviorSupplier.get());
                                }

                                // Add the link text
                                link.add(new Label("linkListLinkLabel", label));

                                item.add(link);
                            }
                        }
                    );
                }
            }
        );
    }
}
