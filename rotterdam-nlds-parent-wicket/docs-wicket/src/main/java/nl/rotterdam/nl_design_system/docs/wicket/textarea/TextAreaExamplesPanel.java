package nl.rotterdam.nl_design_system.docs.wicket.textarea;

import nl.rotterdam.nl_design_system.wicket.components.text_area.RdTextArea;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;

public class TextAreaExamplesPanel extends ExamplesPanel {
    public TextAreaExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdTextArea.class;
    }

    @ComponentExample
    private static RdTextArea<String> exampleTextArea() {
        return new RdTextArea<>("textArea", Model.of(""));
    }

    @ComponentExample
    private static RdTextArea<String> exampleTextAreaRequired() {
        RdTextArea<String> component = new RdTextArea<>("textAreaRequired", Model.of(""));
        component.setRequired(true);
        return component;
    }

    @ComponentExample
    private static RdTextArea<String> exampleTextAreaDisabled() {
        RdTextArea<String> component = new RdTextArea<>("textAreaDisabled", Model.of(""));
        component.setEnabled(false);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleTextArea(), exampleTextAreaRequired(), exampleTextAreaDisabled());
    }
}
