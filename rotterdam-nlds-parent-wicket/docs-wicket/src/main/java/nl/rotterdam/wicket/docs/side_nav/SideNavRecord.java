package nl.rotterdam.wicket.docs.side_nav;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;

public record SideNavRecord<C>(
    RotterdamIconType icon,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
