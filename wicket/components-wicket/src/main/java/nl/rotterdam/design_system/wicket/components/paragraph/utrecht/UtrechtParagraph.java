package nl.rotterdam.design_system.wicket.components.paragraph.utrecht;

import java.io.Serializable;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtParagraph extends Label {

    public UtrechtParagraph(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtParagraphBehavior());
    }

    public UtrechtParagraph(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public UtrechtParagraph(String id, Serializable label, UtrechtParagraphAppearance appearance) {
        this(id, Model.of(label), appearance);
    }

    public UtrechtParagraph(String id, IModel<?> model, UtrechtParagraphAppearance appearance) {
        super(id, model);
        add(new UtrechtParagraphBehavior(appearance));
    }
}
