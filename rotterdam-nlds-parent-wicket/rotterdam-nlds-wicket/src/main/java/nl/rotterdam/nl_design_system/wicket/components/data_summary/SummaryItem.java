package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import java.io.Serializable;
import org.apache.wicket.model.IModel;

/**
 * Represents an item int the data summary component
 * @param label label to show. Not a model, as the items itself are passed as model
 * @param value the {@link SummaryItemValue}
 */
public record SummaryItem(String label, SummaryItemValue value) implements Serializable {

    /**
     * Alternative constructor where label is a model.
     *
     * @param label label to show. Not a model, as the items itself are passed as model
     * @param value the {@link SummaryItemValue}
     */
    public SummaryItem(IModel<String> label, SummaryItemValue value) {
        this(label.getObject(), value);
    }
}
