package nl.rotterdam.nl_design_system.docs.wicket.preserve_data;

import nl.rotterdam.nl_design_system.wicket.components.preserve_data.RdPreserveDataLabel;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;

public class PreserveDataExamplesPanel extends ExamplesPanel {
    public PreserveDataExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdPreserveDataLabel.class;
    }

    @ComponentExample
    private static RdPreserveDataLabel examplePreserveData() {
        return new RdPreserveDataLabel("preserveData", Model.of("Mees de Vos"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePreserveData());
    }
}
