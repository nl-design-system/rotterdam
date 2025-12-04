package nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavRecord;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListRecord;
import nl.rotterdam.nl_design_system.wicket.components.preserve_data.RdPreserveDataLabel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavRecord;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamBasePage;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamPlaceholderPage;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.component.IRequestablePage;
import org.danekja.java.util.function.serializable.SerializableSupplier;

import java.util.List;

import static nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior.supplyOf;

/**
 * Voorbeeld pagina in NL Design System formatting
 *
 * TODO niet af, geen grid systeem gebruikt. Besluit wat we er mee willen
 */
public class MijnLoketPage extends RotterdamBasePage {

    public final List<RdSideNavRecord> sideNavRecords;
    public final List<RdLinkListRecord<? extends IRequestablePage>> linkListLinks;
    public final List<RdBreadcrumbNavRecord<? extends IRequestablePage>> breadcrumbNavLinks;

    public final String username;

    public MijnLoketPage() {
        super("Mijn Loket");
        this.username = "mevrouw Van Bergenhenegouwen";

        this.sideNavRecords = List.of(
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.OVERVIEW),
                "Overzicht",
                MijnLoketPage.class,
                null,
                null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.INBOX),
                "Mijn berichten",
                RotterdamPlaceholderPage.class,
                null,
                2L,
                "2 nieuwe berichten"
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.BOX),
                "Mijn lopende zaken",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.SUMMARY),
                "Zelf regelen",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.COINS),
                "Belastingen",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.MONEY_2),
                "Werk & Inkomen",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.PARKING),
                "Parkeren",
                RotterdamPlaceholderPage.class,
                null, null,
                null
            ),
            new RdSideNavRecord(
                supplyOf(RotterdamIconBehavior.USER),
                "Mijn gegevens",
                RotterdamPlaceholderPage.class,
                null,
                null,
                null
            )
        );

        this.breadcrumbNavLinks = List.of(
            new RdBreadcrumbNavRecord<>(null, "rotterdam.nl", this.getApplication().getHomePage()),
            new RdBreadcrumbNavRecord<>(null, "Mijn Loket", MijnLoketPage.class)
        );

        this.linkListLinks = List.of(
            new RdLinkListRecord<>(null, "Direct regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Meer informatie op Rotterdam.nl", RotterdamPlaceholderPage.class)
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        pageBody.add(new RdSideNavPanel("sideNav", this.sideNavRecords));

        pageBody.add(new RdBreadcrumbNavPanel("breadcrumbNav", this.breadcrumbNavLinks));

        pageBody.add(new RdPreserveDataLabel("name", Model.of(this.username)));
        SerializableSupplier<Behavior> defaultIconBehaviorSupplier  = supplyOf(RotterdamIconBehavior.CHEVRON_RIGHT);
        pageBody.add(new RdLinkListPanel("linkList1", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList2", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList3", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList4", linkListLinks, defaultIconBehaviorSupplier));
    }
}
