package nl.rotterdam.design_system.wicket.components.number_badge.utrecht;

import java.io.Serializable;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtNumberBadge extends Label {

    public UtrechtNumberBadge(String id) {
        this(id, Model.of((String) null));
    }

    public UtrechtNumberBadge(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public UtrechtNumberBadge(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtNumberBadgeBehavior());
    }
}
