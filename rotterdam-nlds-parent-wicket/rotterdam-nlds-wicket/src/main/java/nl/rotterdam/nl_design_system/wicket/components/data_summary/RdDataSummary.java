package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * Simple <a href="https://nldesignsystem.nl/data-summary/">Data Summary</a> implementation based on
 * <a href="https://www.npmjs.com/package/@utrecht/data-list-css">Utrecht Data-List</a>.
 *
 * <p>Only supports one key and one value per item. No actions, no support for multiple keys and values, no multiline
 * items.</p>
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdDataSummary extends GenericPanel<List<SummaryItem>> {

    /**
     * Creates summary.
     * @param id the Wicket ID
     * @param model the list of {@link SummaryItem}s
     */
    public RdDataSummary(String id, IModel<List<SummaryItem>> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(RdDataSummaryBehavior.INSTANCE);
        add(new RdDataSummaryListView(getModel()));
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        setVisible(!getModelObject().isEmpty());
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        assertIsRegularHtmlTag(tag);
    }

    static class RdDataSummaryListView extends ListView<SummaryItem> {

        RdDataSummaryListView(IModel<? extends List<SummaryItem>> model) {
            super("list", model);
        }

        @Override
        protected void populateItem(ListItem<SummaryItem> item) {
            item.add(new DataListItemMarkupContainer(item));
        }

        private static class DataListItemMarkupContainer extends WebMarkupContainer {

            private static final Behavior ITEM_BEHAVIOR_CSS = RdDataSummaryItemCss.ITEM_ELEMENT.asBehavior();
            private static final Behavior KEY_BEHAVIOR_CSS = RdDataSummaryKeyCss.ITEM_KEY_ELEMENT.asBehavior();
            private final ListItem<SummaryItem> item;

            DataListItemMarkupContainer(ListItem<SummaryItem> item) {
                super("item");
                this.item = item;
            }

            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(ITEM_BEHAVIOR_CSS);
                add(
                    new Label("key", item.getModel().map(SummaryItem::label)).add(KEY_BEHAVIOR_CSS),
                    new DataSummaryValueLabel(item.getModel().map(SummaryItem::value))
                );
            }

            private static class DataSummaryValueLabel extends Label {

                private static final Behavior VALUE_BEHAVIOR_CSS = RdDataSummaryValueCss.ITEM_VALUE_ELEMENT.asBehavior();

                private final IModel<SummaryItemValue> valueModel;

                DataSummaryValueLabel(IModel<SummaryItemValue> model) {
                    super("value", model.map(SummaryItemValue::value));
                    valueModel = model;
                }

                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(VALUE_BEHAVIOR_CSS);
                    if (!valueModel.getObject().translate()) {
                        add(AttributeModifier.replace("translate", "no"));
                    }
                }
            }
        }
    }
}
