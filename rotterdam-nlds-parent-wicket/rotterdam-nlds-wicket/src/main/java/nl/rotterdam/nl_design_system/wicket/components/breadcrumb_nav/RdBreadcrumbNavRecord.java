package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.jspecify.annotations.Nullable;

/**
 * An item in the {@link RdBreadcrumbNavPanel}
 * @param icon the icon
 * @param label the label TODO change to model
 * @param target to point the bread crumb to
 * @param <C> the page pointing to TODO support other type of {@link org.apache.wicket.markup.html.link.Link}s and page parameters
 */
public record RdBreadcrumbNavRecord<C extends Page>(@Nullable RotterdamIconType icon, String label, Class<C> target) implements
    Serializable {}
