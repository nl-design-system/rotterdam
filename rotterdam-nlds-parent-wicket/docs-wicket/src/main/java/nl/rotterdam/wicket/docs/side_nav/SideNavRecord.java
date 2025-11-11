package nl.rotterdam.wicket.docs.side_nav;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;

import java.io.Serializable;

public record SideNavRecord<C>(
    RotterdamIconType icon,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
