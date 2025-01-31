package nl.rotterdam.design_system.wicket.components.code_block.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtCodeBlock extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtCodeBlock(String id, IModel<String> textContent) {
        super(id);
        add(new Label(SLOT_ID, textContent));
        add(new UtrechtCodeBlockBehavior());
    }
}
