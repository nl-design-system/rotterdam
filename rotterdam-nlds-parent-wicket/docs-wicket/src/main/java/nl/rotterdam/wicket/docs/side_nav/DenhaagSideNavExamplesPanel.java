package nl.rotterdam.wicket.docs.side_nav;

import static nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavListBehavior.DENHAAG_SIDE_NAV_LIST_BEHAVIOR;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavBehavior;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavItemBehavior;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavLink;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.RotterdamPlaceholderPage;
import nl.rotterdam.wicket.docs.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class DenhaagSideNavExamplesPanel extends Panel {

    public DenhaagSideNavExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleDenhaagSideNav() {
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

        return new WebMarkupContainer("denhaagSideNav") {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(new DenhaagSideNavBehavior());

                add(
                    new WebMarkupContainer("denhaagSideNavList") {
                        @Override
                        protected void onInitialize() {
                            super.onInitialize();

                            add(DENHAAG_SIDE_NAV_LIST_BEHAVIOR);
                            add(
                                new ListView<>("denhaagSideNavItem", links) {
                                    @Override
                                    protected void populateItem(ListItem<SideNavRecord<?>> item) {
                                        item.add(new DenhaagSideNavItemBehavior()); // TODO: should be singleton
                                        SideNavRecord<?> record = item.getModelObject();
                                        String naam = record.label();

                                        // TODO: How do I type this?
                                        @SuppressWarnings({ "rawtypes", "unchecked" })
                                        DenhaagSideNavLink<?> link = new DenhaagSideNavLink(
                                            "denhaagSideNavLink",
                                            record.target()
                                        );

                                        // Optionally add an icon
                                        if (record.icon() != null) {
                                            WebMarkupContainer icon = new WebMarkupContainer("denhaagSideNavLinkIcon");
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
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleDenhaagSideNav());
    }
}
