package nl.rotterdam.wicket.docs.data_summary;

import nl.rotterdam.design_system.wicket.components.data_summary.RdDataSummary;
import nl.rotterdam.design_system.wicket.components.data_summary.SummaryItem;
import nl.rotterdam.design_system.wicket.components.data_summary.SummaryItemValue;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.util.ListModel;

import java.util.List;

public class DataSummaryExamplesPanel extends Panel {

    public DataSummaryExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    public RdDataSummary example() {
        return new RdDataSummary("basic",
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
