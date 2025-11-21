package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.danekja.java.util.function.serializable.SerializableSupplier;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

public record RdSideNavRecord<C extends WebPage>(
    @Nullable SerializableSupplier<Behavior> iconBehaviorSupplier,
    String label,
    Class<C> page,
    @Nullable
    PageParameters parameters,
    @Nullable
    Long numberBadge,
    @Nullable
    String numberBadgeLabel
) implements Serializable {}
