import org.jspecify.annotations.NullMarked;

@NullMarked
module nl.rotterdam.nl_design_system.wicket_extras {
    exports nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

    //noinspection JavaModuleDefinition
    opens nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.prismjs.components;
    //noinspection JavaModuleDefinition
    opens nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.prismjs.themes;

    requires nl.rotterdam.nl_design_system.wicket;
    requires org.apache.wicket.core;
    requires org.danekja.jdk.serializable.functional;
    requires org.jspecify;
    requires com.github.openjson;
}
