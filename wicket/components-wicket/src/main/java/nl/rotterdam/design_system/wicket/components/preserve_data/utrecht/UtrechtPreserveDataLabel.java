package nl.rotterdam.design_system.wicket.components.preserve_data.utrecht;

import static css.WicketComponentsCssReferences.PRESERVE_DATA_HEADER_ITEM;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 *  Mark the given model to be preserved and show it 'as is'.
 *  Example:
 *  <bdi translate="no" class="utrecht-preserve-data" wicket:id="name">Van Bergenhenegouwen</bdi>
 */
public class UtrechtPreserveDataLabel extends Label {

    public UtrechtPreserveDataLabel(String id, IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("bdi");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(AttributeModifier.replace("translate", "no"));
        add(AttributeModifier.append("class", "utrecht-preserve-data"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(PRESERVE_DATA_HEADER_ITEM);
    }
}
