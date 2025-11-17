package nl.rotterdam.nl_design_system.wicket.components.models;

import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

public enum DefaultModels {
    ;

    public static final IModel<@Nullable String> EMPTY_STRING_MODEL = () -> null;
}
