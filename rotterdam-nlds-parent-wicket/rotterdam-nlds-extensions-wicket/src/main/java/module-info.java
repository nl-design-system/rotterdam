import org.jspecify.annotations.NullMarked;

@NullMarked
module nl.rotterdam.nl_design_system.rotterdam_extensions.wicket {
    exports nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon;
    exports nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_logo;

    opens nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon;
    opens nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_logo;

    requires nl.rotterdam.nl_design_system.wicket;
    requires org.apache.wicket.core;
    requires org.jspecify;
}
