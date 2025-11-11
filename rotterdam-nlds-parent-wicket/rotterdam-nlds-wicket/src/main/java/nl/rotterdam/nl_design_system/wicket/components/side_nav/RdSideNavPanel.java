package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.RdNumberBadge;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavListBehavior.SIDE_NAV_LIST_BEHAVIOR;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdSideNavPanel extends Panel {

    public final List<RdSideNavRecord<? extends IRequestablePage>> sideNavRecords;

    public RdSideNavPanel(String id, List<RdSideNavRecord<? extends IRequestablePage>> sideNavRecords) {
        super(id);
        this.sideNavRecords = sideNavRecords;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<RdSideNavRecord<? extends IRequestablePage>> sideNavRecords = this.sideNavRecords;

        add(
            new WebMarkupContainer("sideNav") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new RdSideNavBehavior());

                    add(
                        new WebMarkupContainer("sideNavList") {
                            @Override
                            protected void onInitialize() {
                                super.onInitialize();

                                add(SIDE_NAV_LIST_BEHAVIOR); // TODO should be singleton
                                add(
                                    new ListView<>("sideNavItem", sideNavRecords) {
                                        @Override
                                        protected void populateItem(
                                            ListItem<RdSideNavRecord<? extends IRequestablePage>> item
                                        ) {
                                            item.add(new RdSideNavItemBehavior()); // TODO: should be singleton
                                            RdSideNavRecord<? extends IRequestablePage> record =
                                                item.getModelObject();
                                            var label = record.label();

                                            @SuppressWarnings({ "rawtypes", "unchecked" })
                                            RdSideNavLink<?> link = new RdSideNavLink(
                                                "sideNavLink",
                                                record.target()
                                            );

                                            // Optionally add an icon
                                            WebMarkupContainer icon = new WebMarkupContainer("sideNavLinkIcon");
                                            link.add(icon);
                                            if (record.iconBehaviorSupplier() != null) {
                                                icon.add(record.iconBehaviorSupplier().get());
                                            } else {
                                                icon.setVisible(false);
                                            }

                                            // Add the link text
                                            link.add(new Label("sideNavLinkLabel", label));

                                            // Optionally add a number badge
                                            RdNumberBadge numberBadge = new RdNumberBadge(
                                                "sideNavLinkNumberBadge",
                                                record.numberBadge()
                                            );
                                            numberBadge.setVisible(record.numberBadge() >= 1);
                                            link.add(numberBadge);

                                            item.add(link);
                                        }
                                    }
                                );
                            }
                        }
                    );
                }
            }
        );
    }
}
