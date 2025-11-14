package nl.rotterdam.nl_design_system.wicket.components.link_list;

import org.apache.wicket.behavior.Behavior;
import org.danekja.java.util.function.serializable.SerializableSupplier;

import java.io.Serializable;

public record RdLinkListRecord<C>(SerializableSupplier<Behavior> iconBehaviorSupplier, String label, Class<C> target) implements Serializable {}
