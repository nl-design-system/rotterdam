package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import java.io.Serializable;

import nl.rotterdam.design_system.wicket.components.icon.rotterdam.RotterdamIconType;

public record UtrechtLinkListRecord<C>(RotterdamIconType icon, String label, Class<C> target) implements Serializable {
}
