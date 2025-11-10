package nl.rotterdam.wicket.docs.link_list;

import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListRecord;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import nl.rotterdam.wicket.docs.RotterdamPlaceholderPage;
import nl.rotterdam.wicket.docs.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.request.component.IRequestablePage;

import java.util.List;

public class LinkListExamplesPanel extends ExamplesPanel {

    public LinkListExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdLinkListPanel.class;
    }

    @ComponentExample
    private static Component exampleLinkList() {
        List<RdLinkListRecord<? extends IRequestablePage>> links = List.of(
            new RdLinkListRecord<>(null, "Overzicht", MijnLoketPage.class),
            new RdLinkListRecord<>(null, "Mijn berichten", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Zelf regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Belastingen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Parkeren", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new RdLinkListPanel("linkList", links);
    }

    @ComponentExample
    private static Component exampleLinkListIcon() {
        List<RdLinkListRecord<? extends IRequestablePage>> links = List.of(
            new RdLinkListRecord<>(RotterdamIconType.OVERVIEW, "Overzicht", MijnLoketPage.class),
            new RdLinkListRecord<>(RotterdamIconType.INBOX, "Mijn berichten", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.BOX, "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.SUMMARY, "Zelf regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.COINS, "Belastingen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.MONEY_2, "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.PARKING, "Parkeren", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(RotterdamIconType.USER, "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new RdLinkListPanel("linkListIcon", links);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLinkList());
        add(exampleLinkListIcon());
    }
}
