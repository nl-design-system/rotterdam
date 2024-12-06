package nl.rotterdam.wicket.docs.ordered_list;

import nl.rotterdam.design_system.wicket.components.ordered_list.utrecht.UtrechtOrderedList;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtOrderedListExamplesPanel extends Panel {

    public UtrechtOrderedListExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleOrderedList() {
        return new UtrechtOrderedList("utrechtOrderedList");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleOrderedList());
    }
}
