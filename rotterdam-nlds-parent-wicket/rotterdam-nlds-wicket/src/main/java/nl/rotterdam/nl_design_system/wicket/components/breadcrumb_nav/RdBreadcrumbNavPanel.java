package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import static nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavItemBehavior.BREADCRUMB_NAV_ITEM_BEHAVIOR;
import static nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.RdBreadcrumbNavListBehavior.BREADCRUMB_NAV_LIST_BEHAVIOR;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import java.util.List;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBreadcrumbNavPanel extends Panel {

    public final List<RdBreadcrumbNavRecord<? extends IRequestablePage>> links;

    public RdBreadcrumbNavPanel(String id, List<RdBreadcrumbNavRecord<? extends IRequestablePage>> links) {
        super(id);
        this.links = links;
    }

    private static Component createNavListview(List<RdBreadcrumbNavRecord<? extends IRequestablePage>> links) {
        return new ListView<>("breadcrumbNavItem", links) {
            @Override
            protected void populateItem(ListItem<RdBreadcrumbNavRecord<? extends IRequestablePage>> item) {
                item.add(BREADCRUMB_NAV_ITEM_BEHAVIOR);
                RdBreadcrumbNavRecord<? extends IRequestablePage> record = item.getModelObject();
                String naam = record.label();

                // TODO: How do I type this?
                @SuppressWarnings({ "rawtypes", "unchecked" })
                RdBreadcrumbNavLink<?> link = new RdBreadcrumbNavLink(
                    "breadcrumbNavLink",
                    record.target()
                );

                // Optionally add an icon
                if (record.icon() != null) {
                    WebMarkupContainer icon = new WebMarkupContainer("breadcrumbNavLinkIcon");
                    icon.add(new RotterdamIconBehavior(record.icon()));
                    link.add(icon);
                } else {
                    link.add(new Label("breadcrumbNavLinkIcon", ""));
                }

                // Add the link text
                link.add(new Label("breadcrumbNavLinkLabel", naam));

                item.add(link);
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<RdBreadcrumbNavRecord<? extends IRequestablePage>> links = this.links;

        add(
            new WebMarkupContainer("breadcrumbNav") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new RdBreadcrumbNavBehavior());

                    add(
                        new WebMarkupContainer("breadcrumbNavList") {
                            @Override
                            protected void onInitialize() {
                                super.onInitialize();

                                add(BREADCRUMB_NAV_LIST_BEHAVIOR);
                                add(createNavListview(links));
                            }
                        }
                    );
                }
            }
        );
    }
}
