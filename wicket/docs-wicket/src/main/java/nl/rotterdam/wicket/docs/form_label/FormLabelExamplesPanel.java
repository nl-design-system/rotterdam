package nl.rotterdam.wicket.docs.form_label;

import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormLabelExamplesPanel extends Panel {

    public FormLabelExamplesPanel(String id) {
        super(id);
    }

    // private static Component example1() {
    // return new UtrechtFormLabel("utrechtLabel1").setDefaultModel(Model.of("Voornaam"));
    // return new UtrechtFormLabel("utrechtLabel1", Model.of("Voornaam"));
    // }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // add(example1());
        add(new UtrechtFormLabel("utrechtLabel1", Model.of("Voornaam")));
    }
}
