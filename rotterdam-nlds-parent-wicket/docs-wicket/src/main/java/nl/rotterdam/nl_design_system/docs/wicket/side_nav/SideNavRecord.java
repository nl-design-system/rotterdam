package nl.rotterdam.nl_design_system.docs.wicket.side_nav;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

public record SideNavRecord<C>(
    @Nullable RotterdamIconType icon,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
