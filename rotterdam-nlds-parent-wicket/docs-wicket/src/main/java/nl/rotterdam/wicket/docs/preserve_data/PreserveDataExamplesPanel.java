package nl.rotterdam.wicket.docs.preserve_data;

import nl.rotterdam.nl_design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class PreserveDataExamplesPanel extends Panel {

    public PreserveDataExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtPreserveDataLabel examplePreserveData() {
        return new UtrechtPreserveDataLabel("preserveData", Model.of("Mees de Vos"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePreserveData());
    }
}
