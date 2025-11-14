package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import org.apache.wicket.Page;
import org.apache.wicket.behavior.Behavior;
import org.danekja.java.util.function.serializable.SerializableSupplier;

import java.io.Serializable;

/**
 * An item in the {@link RdBreadcrumbNavPanel}
 * @param iconBehaviorSupplier the supplier for the icon behavior
 * @param label the label TODO change to model
 * @param target to point the bread crumb to
 * @param <C> the page pointing to TODO support other type of {@link org.apache.wicket.markup.html.link.Link}s and page parameters
 */
public record RdBreadcrumbNavRecord<C extends Page>(SerializableSupplier<Behavior> iconBehaviorSupplier, String label, Class<C> target) implements
    Serializable {}
