package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import static css.WicketComponentsCssReferences.FORM_LABEL_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtFormLabel extends Panel {

    public static final String SLOT_ID = "slot";
    private final Label label;

    public UtrechtFormLabel(String id, IModel<?> textContent) {
        super(id);
        label = new Label(SLOT_ID, textContent);
        add(label);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(FORM_LABEL_HEADER_ITEM);
    }
}
