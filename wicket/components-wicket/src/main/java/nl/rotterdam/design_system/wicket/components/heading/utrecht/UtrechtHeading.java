package nl.rotterdam.design_system.wicket.components.heading.utrecht;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

public class UtrechtHeading extends Label {

    public UtrechtHeading(String id, int level) {
        this(id, Model.of((String) null), level);
    }

    public UtrechtHeading(String id, Serializable label, int level) {
        this(id, Model.of(label), level);
    }

    public UtrechtHeading(String id, IModel<?> model, int level) {
        super(id, model);
        add(UtrechtHeadingBehavior.heading(level));
    }
}
