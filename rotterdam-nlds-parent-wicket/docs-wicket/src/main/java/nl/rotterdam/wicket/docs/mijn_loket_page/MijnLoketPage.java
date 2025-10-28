package nl.rotterdam.wicket.docs.mijn_loket_page;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht.UtrechtBreadcrumbNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht.UtrechtBreadcrumbNavRecord;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht.UtrechtLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht.UtrechtLinkListRecord;
import nl.rotterdam.nl_design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataLabel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag.DenhaagSideNavRecord;
import nl.rotterdam.wicket.docs.RotterdamBasePage;
import nl.rotterdam.wicket.docs.RotterdamPlaceholderPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.component.IRequestablePage;

public class MijnLoketPage extends RotterdamBasePage {

    public final List<DenhaagSideNavRecord<? extends IRequestablePage>> sideNavRecords;
    public final List<UtrechtLinkListRecord<? extends IRequestablePage>> linkListLinks;
    public final List<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> breadcrumbNavLinks;

    public final String username;

    public MijnLoketPage() {
        super();
        this.pageTitle = "Mijn Loket";
        this.username = "mevrouw Van Bergenhenegouwen";

        this.sideNavRecords = List.of(
            new DenhaagSideNavRecord<>(RotterdamIconType.OVERVIEW, "Overzicht", MijnLoketPage.class, 0, ""),
            new DenhaagSideNavRecord<>(
                RotterdamIconType.INBOX,
                "Mijn berichten",
                RotterdamPlaceholderPage.class,
                2,
                "2 nieuwe berichten"
            ),
            new DenhaagSideNavRecord<>(
                RotterdamIconType.BOX,
                "Mijn lopende zaken",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new DenhaagSideNavRecord<>(
                RotterdamIconType.SUMMARY,
                "Zelf regelen",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new DenhaagSideNavRecord<>(RotterdamIconType.COINS, "Belastingen", RotterdamPlaceholderPage.class, 0, ""),
            new DenhaagSideNavRecord<>(
                RotterdamIconType.MONEY_2,
                "Werk & Inkomen",
                RotterdamPlaceholderPage.class,
                0,
                ""
            ),
            new DenhaagSideNavRecord<>(RotterdamIconType.PARKING, "Parkeren", RotterdamPlaceholderPage.class, 0, ""),
            new DenhaagSideNavRecord<>(RotterdamIconType.USER, "Mijn gegevens", RotterdamPlaceholderPage.class, 0, "")
        );

        this.breadcrumbNavLinks = List.of(
            new UtrechtBreadcrumbNavRecord<>(null, "rotterdam.nl", this.getApplication().getHomePage()),
            new UtrechtBreadcrumbNavRecord<>(null, "Mijn Loket", MijnLoketPage.class)
        );

        this.linkListLinks = List.of(
            new UtrechtLinkListRecord<>(null, "Direct regelen", RotterdamPlaceholderPage.class),
            new UtrechtLinkListRecord<>(null, "Meer informatie op Rotterdam.nl", RotterdamPlaceholderPage.class)
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        pageBody.add(new DenhaagSideNavPanel("sideNav", this.sideNavRecords));

        pageBody.add(new UtrechtBreadcrumbNavPanel("breadcrumbNav", this.breadcrumbNavLinks));

        pageBody.add(new UtrechtPreserveDataLabel("name", Model.of(this.username)));
        pageBody.add(new UtrechtLinkListPanel("linkList1", linkListLinks));
        pageBody.add(new UtrechtLinkListPanel("linkList2", linkListLinks));
        pageBody.add(new UtrechtLinkListPanel("linkList3", linkListLinks));
        pageBody.add(new UtrechtLinkListPanel("linkList4", linkListLinks));
    }
}
