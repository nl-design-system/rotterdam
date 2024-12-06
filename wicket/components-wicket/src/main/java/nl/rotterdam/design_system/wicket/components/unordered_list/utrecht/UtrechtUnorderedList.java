package nl.rotterdam.design_system.wicket.components.unordered_list.utrecht;

import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtUnorderedList extends Panel {

    public UtrechtUnorderedList(String id) {
        super(id);
        add(new UtrechtUnorderedListBehavior());
    }
}
