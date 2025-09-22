package nl.rotterdam.design_system.wicket.components.component_tag;

import org.apache.wicket.markup.ComponentTag;

public enum ComponentTagUtils {
    ;
    public static void appendCssClassesTo(ComponentTag tag, String cssClassses) {
        tag.append("class", cssClassses, " ");
    }
}
