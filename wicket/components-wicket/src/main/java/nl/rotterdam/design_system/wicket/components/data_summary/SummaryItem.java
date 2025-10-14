package nl.rotterdam.design_system.wicket.components.data_summary;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

public record SummaryItem(String label, SummaryItemValue value) {

    public SummaryItem(IModel<String> label, SummaryItemValue value) {
        this(label.getObject(), value);
    }


}

