package nl.rotterdam.wicket.docs.preserve_data;

import nl.rotterdam.design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class UtrechtPreserveDataExamplesPanel extends Panel {

    public UtrechtPreserveDataExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component examplePreserveData() {
        return new UtrechtPreserveDataLabel("utrechtPreserveData", Model.of("Mees de Vos"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePreserveData());
    }
}
