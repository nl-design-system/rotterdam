package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import org.apache.wicket.behavior.Behavior;
import org.danekja.java.util.function.serializable.SerializableSupplier;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

public record RdSideNavRecord<C>(
    @Nullable SerializableSupplier<Behavior> iconBehaviorSupplier,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
