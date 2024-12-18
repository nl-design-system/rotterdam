package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.component.IRequestablePage;

import java.util.List;

public class UtrechtBreadcrumbNavPanel extends Panel {

    public List<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> links;

    public UtrechtBreadcrumbNavPanel(String id, List<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> links) {
        super(id);
        this.links = links;
    }

    private static Component createNavListview(List<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> links) {
        return new ListView<>("utrechtBreadcrumbNavItem", links) {
            @Override
            protected void populateItem(
                ListItem<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> item
            ) {
                item.add(UtrechtBreadcrumbNavItemBehavior.INSTANCE);
                UtrechtBreadcrumbNavRecord<? extends IRequestablePage> record =
                    item.getModelObject();
                String naam = record.label();

                // TODO: How do I type this?
                @SuppressWarnings({"rawtypes", "unchecked"})
                UtrechtBreadcrumbNavLink<?> link = new UtrechtBreadcrumbNavLink(
                    "utrechtBreadcrumbNavLink",
                    record.target()
                );

                // Optionally add an icon
                if (record.icon() != null) {
                    WebMarkupContainer icon = new WebMarkupContainer(
                        "utrechtBreadcrumbNavLinkIcon"
                    );
                    icon.add(new RotterdamIconBehavior(record.icon()));
                    link.add(icon);
                } else {
                    link.add(new Label("utrechtBreadcrumbNavLinkIcon", ""));
                }

                // Add the link text
                link.add(new Label("utrechtBreadcrumbNavLinkLabel", naam));

                item.add(link);
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<UtrechtBreadcrumbNavRecord<? extends IRequestablePage>> links = this.links;

        add(
            new WebMarkupContainer("utrechtBreadcrumbNav") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new UtrechtBreadcrumbNavBehavior());

                    add(
                        new WebMarkupContainer("utrechtBreadcrumbNavList") {
                            @Override
                            protected void onInitialize() {
                                super.onInitialize();

                                add(UtrechtBreadcrumbNavListBehavior.INSTANCE);
                                add(createNavListview(links)
                                );
                            }
                        }
                    );
                }
            }
        );
    }
}
