import org.jspecify.annotations.NullMarked;

@NullMarked
module nl.rotterdam.nl_design_system.wicket.test_common {
    exports nl.rotterdam.nl_design_system.wicket.test_common;

    opens nl.rotterdam.nl_design_system.wicket.test_common;

    requires de.agilecoders.wicket.webjars;
    requires org.apache.wicket.core;
    requires org.apache.wicket.tester;
    requires org.jsoup;
    requires org.jspecify;
    requires org.junit.jupiter.api;
}
