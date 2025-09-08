package nl.rotterdam.design_system.wicket.components.ordered_list.utrecht;

import java.io.Serializable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtOrderedListItem extends Label {

    public UtrechtOrderedListItem(String id) {
        this(id, Model.of((String) null));
    }

    public UtrechtOrderedListItem(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public UtrechtOrderedListItem(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtOrderedListBehavior());
    }
}
