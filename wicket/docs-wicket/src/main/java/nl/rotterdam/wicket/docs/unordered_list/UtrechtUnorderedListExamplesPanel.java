package nl.rotterdam.wicket.docs.unordered_list;

import nl.rotterdam.design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedList;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtUnorderedListExamplesPanel extends Panel {

    public UtrechtUnorderedListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleUnorderedList() {
        return new UtrechtUnorderedList("utrechtUnorderedList");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleUnorderedList());
    }
}
