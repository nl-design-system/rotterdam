package nl.rotterdam.design_system.wicket.components.component_tag;

import org.apache.wicket.markup.ComponentTag;

public enum ComponentTagUtils {
    ;

    /**
     * @since 25-sep-2025
     * @deprecated use {@link nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames} with an
     * enum instead. Use of CSS literals is discouraged.
     */
    @Deprecated(forRemoval = true, since = "2025-09-20")
    public static void appendCssClassesTo(ComponentTag tag, String cssClasses) {
        tag.append("class", cssClasses, " ");
    }
}
