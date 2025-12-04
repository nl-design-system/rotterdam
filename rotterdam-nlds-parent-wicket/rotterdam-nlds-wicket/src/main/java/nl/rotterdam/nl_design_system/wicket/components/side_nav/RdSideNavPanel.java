package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.number_badge.RdNumberBadge;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import java.util.Collection;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <a href="https://nldesignsystem.nl/side-navigation/">NL Design System Side Navigation</a> component.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdSideNavPanel extends GenericPanel<List<RdSideNavRecord>> {

    /**
     * Create new instance
     *
     * @param id          the Wicket ID
     * @param modelObject records to add
     */
    public RdSideNavPanel(String id, Collection<RdSideNavRecord> modelObject) {
        super(id, new ListModel<>(List.copyOf(modelObject)));
    }

    /**
     * Create new instance
     *
     * @param id    the Wicket ID
     * @param model records to add
     */
    public RdSideNavPanel(String id, IModel<List<RdSideNavRecord>> model) {
        super(id, model);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        assertIsRegularHtmlTag(tag);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<RdSideNavRecord> sideNavRecords = getModelObject();

        add(RdSideNavBehavior.INSTANCE);

        add(new WebMarkupContainer("sideNavList") {

            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(RdSideNavListBehavior.INSTANCE);
                add(new ListView<>("sideNavItem", sideNavRecords) {
                    @Override
                    protected void populateItem(ListItem<RdSideNavRecord> item) {
                        item.add(RdSideNavItemBehavior.INSTANCE);

                        RdSideNavRecord sideNavRecord = item.getModelObject();

                        var label = sideNavRecord.label();

                        RdSideNavLink<? extends WebPage> link = new RdSideNavLink<>("sideNavLink", sideNavRecord.page(), sideNavRecord.parameters());

                        // Optionally add an icon
                        WebMarkupContainer icon = new WebMarkupContainer("sideNavLinkIcon");
                        link.add(icon);
                        if (sideNavRecord.iconBehaviorSupplier() != null) {
                            icon.add(sideNavRecord.iconBehaviorSupplier().get());
                        } else {
                            icon.setVisible(false);
                        }

                        // Add the link text
                        link.add(new Label("sideNavLinkLabel", label), new RdNumberBadge("sideNavLinkNumberBadge", sideNavRecord.numberBadge()).setVisible(sideNavRecord.numberBadge() != null));

                        item.add(link);
                    }
                });
            }
        });
    }
}
