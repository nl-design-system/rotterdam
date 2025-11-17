package nl.rotterdam.nl_design_system.docs.wicket.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.data_summary.RdDataSummary;
import nl.rotterdam.nl_design_system.wicket.components.data_summary.SummaryItem;
import nl.rotterdam.nl_design_system.wicket.components.data_summary.SummaryItemValue;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.util.ListModel;

import java.util.List;

public class DataSummaryExamplesPanel extends ExamplesPanel {
    public DataSummaryExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDataSummary.class;
    }

    @ComponentExample
    public RdDataSummary example() {
        return new RdDataSummary(
            "basic",
            new ListModel<>(
                List.of(
                    new SummaryItem("BSN", new SummaryItemValue("111111110", false)),
                    new SummaryItem("Voornaam", new SummaryItemValue("Corné", false)),
                    new SummaryItem("Achternaam", new SummaryItemValue("de Vos", false))
                )
            )
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(example());
    }
}
