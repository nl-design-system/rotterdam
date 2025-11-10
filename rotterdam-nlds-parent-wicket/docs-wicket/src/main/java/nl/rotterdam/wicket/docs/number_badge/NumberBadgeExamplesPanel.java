package nl.rotterdam.wicket.docs.number_badge;

import nl.rotterdam.nl_design_system.wicket.components.number_badge.RdNumberBadge;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.model.Model;

public class NumberBadgeExamplesPanel extends ExamplesPanel {
    public NumberBadgeExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdNumberBadge.class;
    }

    @ComponentExample
    private static RdNumberBadge exampleNumberBadge() {
        return new RdNumberBadge("numberBadge", Model.of("42"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleNumberBadge());
    }
}
