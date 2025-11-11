package nl.rotterdam.nl_design_system.wicket.components.link_list;

import org.apache.wicket.behavior.Behavior;

import java.io.Serializable;
import java.util.function.Supplier;

public record RdLinkListRecord<C>(Supplier<Behavior> iconBehaviorSupplier, String label, Class<C> target) implements Serializable {}
