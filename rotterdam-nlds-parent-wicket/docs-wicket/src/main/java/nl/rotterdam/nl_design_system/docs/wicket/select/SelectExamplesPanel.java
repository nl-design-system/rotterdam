package nl.rotterdam.nl_design_system.docs.wicket.select;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.select.RdSelect;
import org.apache.wicket.model.Model;

import java.util.List;

public class SelectExamplesPanel extends ExamplesPanel {
    public SelectExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdSelect.class;
    }

    @ComponentExample
    static RdSelect<String> exampleBase() {
        return new RdSelect<>("base", Model.of(), List.of("option1", "option2"));
    }

    @ComponentExample
    static RdSelect<String> exampleRequired() {
        var select = new RdSelect<>("required", Model.of(), List.of("option1", "option2"));
        select.setRequired(true);
        return select;
    }

    @ComponentExample
    static RdSelect<String> exampleSelected() {
        return new RdSelect<>("selected", Model.of("option1"), List.of("option1", "option2"));
    }

    @ComponentExample
    static RdSelect<String> exampleInvalid() {
        var select = new RdSelect<>("invalid", Model.of(), List.of("option1", "option2"));
        select.error("some error");
        return select;
    }

    @ComponentExample
    static RdSelect<String> exampleDisabled() {
        var select = new RdSelect<>("disabled", Model.of(), List.of("option1", "option2"));
        select.setEnabled(false);
        return select;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(exampleBase(), exampleRequired(), exampleSelected(), exampleInvalid(), exampleDisabled());
    }
}
