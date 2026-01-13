package nl.rotterdam.nl_design_system.wicket.components.models;

import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

public enum DefaultModels {
    ;

    public static final IModel<@Nullable String> NULL_STRING_MODEL = () -> null;
    public static final IModel<@Nullable LocalDateTime> NULL_LOCAL_DATE_TIME = () -> null;
}
