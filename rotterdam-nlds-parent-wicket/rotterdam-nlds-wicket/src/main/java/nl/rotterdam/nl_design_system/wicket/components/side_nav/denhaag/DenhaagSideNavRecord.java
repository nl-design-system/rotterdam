package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;

public record DenhaagSideNavRecord<C>(
    RotterdamIconType icon,
    String label,
    Class<C> target,
    long numberBadge,
    String numberBadgeLabel
) implements Serializable {}
