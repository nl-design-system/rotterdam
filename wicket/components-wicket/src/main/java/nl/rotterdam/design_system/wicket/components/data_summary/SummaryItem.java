package nl.rotterdam.design_system.wicket.components.data_summary;

import org.apache.wicket.model.IModel;

import java.io.Serializable;

public record SummaryItem(String label, SummaryItemValue value) implements Serializable {

    public SummaryItem(IModel<String> label, SummaryItemValue value) {
        this(label.getObject(), value);
    }


}

