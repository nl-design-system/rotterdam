package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;

public record RdBreadcrumbNavRecord<C>(RotterdamIconType icon, String label, Class<C> target) implements
    Serializable {}
