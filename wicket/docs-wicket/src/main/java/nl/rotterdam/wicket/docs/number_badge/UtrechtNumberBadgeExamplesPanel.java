package nl.rotterdam.wicket.docs.number_badge;

import nl.rotterdam.design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class UtrechtNumberBadgeExamplesPanel extends Panel {

    public UtrechtNumberBadgeExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleNumberBadge() {
        return new UtrechtNumberBadge("utrechtNumberBadge", Model.of("42"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleNumberBadge());
    }
}
