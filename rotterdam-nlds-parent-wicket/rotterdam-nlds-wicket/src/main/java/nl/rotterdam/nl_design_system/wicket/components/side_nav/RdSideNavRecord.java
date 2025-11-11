package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import org.apache.wicket.behavior.Behavior;

import java.io.Serializable;
import java.util.function.Supplier;

public record RdSideNavRecord<C>(
    Supplier<Behavior> iconBehaviorSupplier,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
