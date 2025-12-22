package nl.rotterdam.nl_design_system.docs.wicket.form_summary;

import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.form_summary.RdFormSummary;

public class FormSummaryExamplesPanel extends ExamplesPanel {
    public FormSummaryExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormSummary.class;
    }
}
