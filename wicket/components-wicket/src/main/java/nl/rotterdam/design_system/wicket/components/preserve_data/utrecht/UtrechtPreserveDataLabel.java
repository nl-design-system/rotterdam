package nl.rotterdam.design_system.wicket.components.preserve_data.utrecht;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.attribute_appender.AttributeAppenders.appendCssClassBehavior;
import static nl.rotterdam.design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataCssClasses.UTRECHT_PRESERVE_DATA_CLASS_NAME;

/**
 *  Mark the given model to be preserved and show it 'as is'.
 *  Example:
 *  <bdi translate="no" class="utrecht-preserve-data" wicket:id="name">Van Bergenhenegouwen</bdi>
 */
public class UtrechtPreserveDataLabel extends Label {

    public UtrechtPreserveDataLabel(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtPreserveDataBehavior());
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
        add(appendCssClassBehavior(UTRECHT_PRESERVE_DATA_CLASS_NAME));
    }
}
