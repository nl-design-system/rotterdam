package nl.rotterdam.nl_design_system.docs.wicket.side_nav;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamPlaceholderPage;
import nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page.MijnLoketPage;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavRecord;
import org.apache.wicket.Component;
import org.apache.wicket.model.util.ListModel;

import java.util.List;

public class SideNavExamplesPanel extends ExamplesPanel {

    public SideNavExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdSideNavPanel.class;
    }

    @ComponentExample
    private static Component exampleSideNav() {
        List<RdSideNavRecord> links = List.of(
            new RdSideNavRecord(
                RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.OVERVIEW),
                "Overzicht",
                MijnLoketPage.class,
                null,
                null,
                null),
            new RdSideNavRecord(
                RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.INBOX),
                "Mijn berichten",
                RotterdamPlaceholderPage.class,
                null,
                2L,
                "2 nieuwe berichten"
            ),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.BOX),
                "Mijn lopende zaken",
                RotterdamPlaceholderPage.class,
                null,
                0L,
                null),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.SUMMARY),
                "Zelf regelen",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.COINS),
                "Belastingen",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.MONEY_2),
                "Werk & Inkomen",
                RotterdamPlaceholderPage.class,
                null,
                0L,
                null),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.PARKING),
                "Parkeren",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null),
            new RdSideNavRecord(RotterdamIconBehavior.supplyOf(RotterdamIconBehavior.USER),
                "Mijn gegevens",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            )
        );

        return new RdSideNavPanel("sideNav", new ListModel<>(links));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleSideNav());
    }
}
