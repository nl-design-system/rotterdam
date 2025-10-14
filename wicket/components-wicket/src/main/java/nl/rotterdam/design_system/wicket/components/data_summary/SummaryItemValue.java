package nl.rotterdam.design_system.wicket.components.data_summary;

import java.io.Serializable;

public record SummaryItemValue(
    Serializable value,
    boolean translate
) {

}