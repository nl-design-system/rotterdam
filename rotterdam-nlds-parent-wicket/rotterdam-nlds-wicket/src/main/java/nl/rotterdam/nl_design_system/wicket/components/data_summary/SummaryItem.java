package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import java.io.Serializable;
import org.apache.wicket.model.IModel;

public record SummaryItem(String label, SummaryItemValue value) implements Serializable {
    public SummaryItem(IModel<String> label, SummaryItemValue value) {
        this(label.getObject(), value);
    }
}
