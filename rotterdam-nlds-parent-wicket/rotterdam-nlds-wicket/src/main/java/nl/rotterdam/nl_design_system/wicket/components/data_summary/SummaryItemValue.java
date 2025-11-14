package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import java.io.Serializable;

/**
 * Value representation for a data summary item
 * @param value, such as a String or other data type. If converter is registered, it will be used.
 * @param translate whether the value is translatable. If false this will be indicated in the markup.
 */
public record SummaryItemValue(Serializable value, boolean translate) implements Serializable {}
