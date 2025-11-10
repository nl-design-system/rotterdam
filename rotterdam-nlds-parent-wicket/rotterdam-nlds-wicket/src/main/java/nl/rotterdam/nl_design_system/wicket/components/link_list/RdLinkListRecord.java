package nl.rotterdam.nl_design_system.wicket.components.link_list;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconType;

public record RdLinkListRecord<C>(RotterdamIconType icon, String label, Class<C> target) implements Serializable {}
