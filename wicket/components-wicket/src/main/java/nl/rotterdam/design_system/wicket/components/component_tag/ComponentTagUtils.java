package nl.rotterdam.design_system.wicket.components.component_tag;

import org.apache.wicket.markup.ComponentTag;

public enum ComponentTagUtils {
    ;
    @Deprecated
    public static void appendCssClassesTo(ComponentTag tag, String cssClasses) {
        tag.append("class", cssClasses, " ");
    }
}
