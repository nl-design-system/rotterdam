package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtAlert extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtAlert(String id, IModel<String> textContent, UtrechtAlertType type) {
        super(id);
        WebMarkupContainer container = new WebMarkupContainer("alert") {
            @Override
            public void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                if (!tag.isClose()) {
                    tag.append("class", "utrecht-alert--" + type.type, " ");
                }
            }
        };
        add(container);
        container.add(UtrechtAlertBehavior.utrechtAlert(type));
        container.add(new Label(SLOT_ID, textContent));
    }
}
