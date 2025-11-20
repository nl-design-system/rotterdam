import org.jspecify.annotations.NullMarked;

@NullMarked
module nl.rotterdam.nl_design_system.wicket_extras {
    exports nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

    opens nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;
    // For the JavaScript files.
    //noinspection JavaModuleDefinition
    opens nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.prismjs.components;
    // For the CSS files.
    //noinspection JavaModuleDefinition
    opens nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.prismjs.themes;

    requires nl.rotterdam.nl_design_system.wicket;
    requires org.apache.wicket.core;
    requires org.apache.wicket.util;
    requires org.danekja.jdk.serializable.functional;
    requires org.jspecify;
}
