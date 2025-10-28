package nl.rotterdam.wicket.docs.link_list;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht.UtrechtLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht.UtrechtLinkListRecord;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.RotterdamPlaceholderPage;
import nl.rotterdam.wicket.docs.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

public class LinkListExamplesPanel extends Panel {

    public LinkListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleLinkList() {
        List<UtrechtLinkListRecord<? extends IRequestablePage>> links = List.of(
            new UtrechtLinkListRecord<>(null, "Overzicht", MijnLoketPage.class),
            new UtrechtLinkListRecord<>(null, "Mijn berichten", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Zelf regelen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Belastingen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Parkeren", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new UtrechtLinkListPanel("linkList", links);
    }

    @ComponentExample
    private static Component exampleLinkListIcon() {
        List<UtrechtLinkListRecord<? extends IRequestablePage>> links = List.of(
            new UtrechtLinkListRecord<>(RotterdamIconType.OVERVIEW, "Overzicht", MijnLoketPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.INBOX, "Mijn berichten", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.BOX, "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.SUMMARY, "Zelf regelen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.COINS, "Belastingen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.MONEY_2, "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.PARKING, "Parkeren", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(RotterdamIconType.USER, "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new UtrechtLinkListPanel("linkListIcon", links);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLinkList());
        add(exampleLinkListIcon());
    }
}
