package nl.rotterdam.design_system.wicket.components.code_block.utrecht;

import static css.WicketComponentsCssReferences.CODE_BLOCK_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtCodeBlock extends Panel {

    public static final String SLOT_ID = "slot";
    private final Label label;

    public UtrechtCodeBlock(String id, IModel<String> textContent) {
        super(id);
        label = new Label(SLOT_ID, textContent);
        add(label);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CODE_BLOCK_HEADER_ITEM);
    }
}
