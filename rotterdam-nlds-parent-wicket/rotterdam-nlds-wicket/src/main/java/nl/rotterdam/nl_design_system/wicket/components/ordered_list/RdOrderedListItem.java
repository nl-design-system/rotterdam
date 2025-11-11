package nl.rotterdam.nl_design_system.wicket.components.ordered_list;

import java.io.Serializable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class RdOrderedListItem extends Label {

    public RdOrderedListItem(String id) {
        this(id, Model.of((String) null));
    }

    public RdOrderedListItem(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public RdOrderedListItem(String id, IModel<?> model) {
        super(id, model);
        add(new RdOrderedListBehavior());
    }
}
