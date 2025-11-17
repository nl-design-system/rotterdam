import org.jspecify.annotations.NullMarked;

@NullMarked
module nl.rotterdam.nl_design_system.rotterdam_css.wicket {
    exports nl.rotterdam.nl_design_system.rotterdam_css.wicket;

    opens nl.rotterdam.nl_design_system.rotterdam_css.wicket;

    requires org.apache.wicket.core;
    requires org.jspecify;
}
