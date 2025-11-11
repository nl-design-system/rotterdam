package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import org.apache.wicket.behavior.Behavior;

import java.io.Serializable;
import java.util.function.Supplier;

public record RdBreadcrumbNavRecord<C>(Supplier<Behavior> iconBehaviorSupplier, String label, Class<C> target) implements
    Serializable {}
