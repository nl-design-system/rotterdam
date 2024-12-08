package nl.rotterdam.wicket.docs.side_nav;

import java.io.Serializable;

public record SideNavRecord<C>(String label, Class<C> target, long numberBadge, String numberBadgeLabel)
    implements Serializable {}
