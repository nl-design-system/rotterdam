package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavListBehavior.DENHAAG_SIDE_NAV_LIST_BEHAVIOR;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class DenhaagSideNavPanel extends Panel {

    public final List<DenhaagSideNavRecord<? extends IRequestablePage>> sideNavRecords;

    public DenhaagSideNavPanel(String id, List<DenhaagSideNavRecord<? extends IRequestablePage>> sideNavRecords) {
        super(id);
        this.sideNavRecords = sideNavRecords;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<DenhaagSideNavRecord<? extends IRequestablePage>> sideNavRecords = this.sideNavRecords;

        add(
            new WebMarkupContainer("denhaagSideNav") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new DenhaagSideNavBehavior());

                    add(
                        new WebMarkupContainer("denhaagSideNavList") {
                            @Override
                            protected void onInitialize() {
                                super.onInitialize();

                                add(DENHAAG_SIDE_NAV_LIST_BEHAVIOR); // TODO should be singleton
                                add(
                                    new ListView<>("denhaagSideNavItem", sideNavRecords) {
                                        @Override
                                        protected void populateItem(
                                            ListItem<DenhaagSideNavRecord<? extends IRequestablePage>> item
                                        ) {
                                            item.add(new DenhaagSideNavItemBehavior()); // TODO: should be singleton
                                            DenhaagSideNavRecord<? extends IRequestablePage> record =
                                                item.getModelObject();
                                            String naam = record.label();

                                            // TODO: How do I type this?
                                            @SuppressWarnings({ "rawtypes", "unchecked" })
                                            DenhaagSideNavLink<?> link = new DenhaagSideNavLink(
                                                "denhaagSideNavLink",
                                                record.target()
                                            );

                                            // Optionally add an icon
                                            if (record.icon() != null) {
                                                WebMarkupContainer icon = new WebMarkupContainer(
                                                    "denhaagSideNavLinkIcon"
                                                );
                                                icon.add(new RotterdamIconBehavior(record.icon()));
                                                link.add(icon);
                                            } else {
                                                link.add(new Label("denhaagSideNavLinkIcon", ""));
                                            }

                                            // Add the link text
                                            link.add(new Label("denhaagSideNavLinkLabel", naam));

                                            // Optionally add a number badge
                                            UtrechtNumberBadge numberBadge = new UtrechtNumberBadge(
                                                "denhaagSideNavLinkNumberBadge",
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
