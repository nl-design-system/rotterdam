package nl.rotterdam.nl_design_system.docs.wicket.side_nav;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.RdNumberBadge;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavBehavior;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavItemBehavior;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavLink;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamPlaceholderPage;
import nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavListBehavior.SIDE_NAV_LIST_BEHAVIOR;

public class RdSideNavExamplesPanel extends ExamplesPanel {

    public RdSideNavExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdSideNavPanel.class;
    }

    @ComponentExample
    private static Component exampleSideNav() {
        List<SideNavRecord<?>> links = List.of(
            new SideNavRecord<>(RotterdamIconType.OVERVIEW, "Overzicht", MijnLoketPage.class, 0, ""),
            new SideNavRecord<>(
                RotterdamIconType.INBOX,
                "Mijn berichten",
                RotterdamPlaceholderPage.class,
                2,
                "2 nieuwe berichten"
            ),
            new SideNavRecord<>(RotterdamIconType.BOX, "Mijn lopende zaken", RotterdamPlaceholderPage.class, 0, ""),
            new SideNavRecord<>(RotterdamIconType.SUMMARY, "Zelf regelen", RotterdamPlaceholderPage.class, 0, ""),
            new SideNavRecord<>(RotterdamIconType.COINS, "Belastingen", RotterdamPlaceholderPage.class, 0, ""),
            new SideNavRecord<>(RotterdamIconType.MONEY_2, "Werk & Inkomen", RotterdamPlaceholderPage.class, 0, ""),
            new SideNavRecord<>(RotterdamIconType.PARKING, "Parkeren", RotterdamPlaceholderPage.class, 0, ""),
            new SideNavRecord<>(RotterdamIconType.USER, "Mijn gegevens", RotterdamPlaceholderPage.class, 0, "")
        );

        return new WebMarkupContainer("sideNav") {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(RdSideNavBehavior.INSTANCE);

                add(
                    new WebMarkupContainer("sideNavList") {
                        @Override
                        protected void onInitialize() {
                            super.onInitialize();

                            add(SIDE_NAV_LIST_BEHAVIOR);
                            add(
                                new ListView<>("sideNavItem", links) {
                                    @Override
                                    protected void populateItem(ListItem<SideNavRecord<?>> item) {
                                        item.add(new RdSideNavItemBehavior()); // TODO: should be singleton
                                        SideNavRecord<?> record = item.getModelObject();
                                        String naam = record.label();

                                        @SuppressWarnings({ "rawtypes", "unchecked" })
                                        RdSideNavLink<?> link = new RdSideNavLink(
                                            "sideNavLink",
                                            record.target(),
                                            new PageParameters());

                                        // Optionally add an icon
                                        if (record.icon() != null) {
                                            WebMarkupContainer icon = new WebMarkupContainer("sideNavLinkIcon");
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
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleSideNav());
    }
}
