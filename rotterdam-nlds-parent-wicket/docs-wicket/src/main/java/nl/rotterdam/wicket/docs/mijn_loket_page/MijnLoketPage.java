package nl.rotterdam.wicket.docs.mijn_loket_page;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavRecord;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListRecord;
import nl.rotterdam.nl_design_system.wicket.components.preserve_data.RdPreserveDataLabel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavRecord;
import nl.rotterdam.wicket.docs.RotterdamBasePage;
import nl.rotterdam.wicket.docs.RotterdamPlaceholderPage;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.component.IRequestablePage;
import org.danekja.java.util.function.serializable.SerializableSupplier;

import java.util.List;

public class MijnLoketPage extends RotterdamBasePage {

    public final List<RdSideNavRecord<? extends IRequestablePage>> sideNavRecords;
    public final List<RdLinkListRecord<? extends IRequestablePage>> linkListLinks;
    public final List<RdBreadcrumbNavRecord<? extends IRequestablePage>> breadcrumbNavLinks;

    public final String username;

    public MijnLoketPage() {
        super();
        this.pageTitle = "Mijn Loket";
        this.username = "mevrouw Van Bergenhenegouwen";

        this.sideNavRecords = List.of(
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.OVERVIEW),
                "Overzicht",
                MijnLoketPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.INBOX),
                "Mijn berichten",
                RotterdamPlaceholderPage.class,
                2,
                "2 nieuwe berichten"
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.BOX),
                "Mijn lopende zaken",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.SUMMARY),
                "Zelf regelen",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.COINS),
                "Belastingen",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.MONEY_2),
                "Werk & Inkomen",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.PARKING),
                "Parkeren",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new RdSideNavRecord<>(
                (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.USER),
                "Mijn gegevens",
                RotterdamPlaceholderPage.class,
                0,
                ""
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
        SerializableSupplier<Behavior> defaultIconBehaviorSupplier = () -> new RotterdamIconBehavior(RotterdamIconType.CHEVRON_RIGHT);
        pageBody.add(new RdLinkListPanel("linkList1", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList2", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList3", linkListLinks, defaultIconBehaviorSupplier));
        pageBody.add(new RdLinkListPanel("linkList4", linkListLinks, defaultIconBehaviorSupplier));
    }
}
