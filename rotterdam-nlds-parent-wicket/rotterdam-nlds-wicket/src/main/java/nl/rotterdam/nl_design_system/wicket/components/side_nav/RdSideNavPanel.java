package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavListBehavior.SIDE_NAV_LIST_BEHAVIOR;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.RdNumberBadge;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

/**
 * <a href="https://nldesignsystem.nl/side-navigation/">NL Design System Side Navigation</a> component.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdSideNavPanel extends Panel {

    private final List<RdSideNavRecord<? extends IRequestablePage>> sideNavRecords;

    /**
     * Create new instance
     * @param id the Wicket ID
     * @param sideNavRecords records to add
     *                       TODO refactor to model.
     */
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
                    add(RdSideNavBehavior.INSTANCE);

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
                                            String naam = record.label();

                                            // TODO: How do I type this?
                                            @SuppressWarnings({ "rawtypes", "unchecked" })
                                            RdSideNavLink<?> link = new RdSideNavLink(
                                                "sideNavLink",
                                                record.target()
                                            );

                                            // Optionally add an icon
                                            if (record.icon() != null) {
                                                WebMarkupContainer icon = new WebMarkupContainer(
                                                    "sideNavLinkIcon"
                                                );
                                                icon.add(new RotterdamIconBehavior(record.icon()));
                                                link.add(icon);
                                            } else {
                                                link.add(new Label("sideNavLinkIcon", ""));
                                            }

                                            // Add the link text
                                            link.add(new Label("sideNavLinkLabel", naam));

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
