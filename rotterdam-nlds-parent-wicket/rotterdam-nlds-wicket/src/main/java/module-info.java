import org.jspecify.annotations.NullMarked;

@NullMarked
module rotterdam.nlds.wicket {

    exports nl.rotterdam.nl_design_system.wicket.components.body;
    exports nl.rotterdam.nl_design_system.wicket.components.column_layout;
    exports nl.rotterdam.nl_design_system.wicket.components.data_summary;
    exports nl.rotterdam.nl_design_system.wicket.components.dialog;
    exports nl.rotterdam.nl_design_system.wicket.components.form_field;
    exports nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;
    exports nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;
    exports nl.rotterdam.nl_design_system.wicket.components.heading;
    exports nl.rotterdam.nl_design_system.wicket.components.heading_group;
    exports nl.rotterdam.nl_design_system.wicket.components.html_content;
    exports nl.rotterdam.nl_design_system.wicket.components.icon;
    exports nl.rotterdam.nl_design_system.wicket.components.icon_button;
    exports nl.rotterdam.nl_design_system.wicket.components.logo;
    exports nl.rotterdam.nl_design_system.wicket.components.page_body;
    exports nl.rotterdam.nl_design_system.wicket.components.page_footer;
    exports nl.rotterdam.nl_design_system.wicket.components.page_header;
    exports nl.rotterdam.nl_design_system.wicket.components.page_layout;
    exports nl.rotterdam.nl_design_system.wicket.components;
    exports nl.rotterdam.nl_design_system.wicket.html;
    exports nl.rotterdam.nl_design_system.wicket.internal.components.button_border;


    opens nl.rotterdam.nl_design_system.wicket.components.body;
    opens nl.rotterdam.nl_design_system.wicket.components.column_layout;
    opens nl.rotterdam.nl_design_system.wicket.components.data_summary;
    opens nl.rotterdam.nl_design_system.wicket.components.dialog;
    opens nl.rotterdam.nl_design_system.wicket.components.form_field;
    opens nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;
    opens nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;
    opens nl.rotterdam.nl_design_system.wicket.components.heading;
    opens nl.rotterdam.nl_design_system.wicket.components.heading_group;
    opens nl.rotterdam.nl_design_system.wicket.components.html_content;
    opens nl.rotterdam.nl_design_system.wicket.components.icon;
    opens nl.rotterdam.nl_design_system.wicket.components.icon_button;
    opens nl.rotterdam.nl_design_system.wicket.components.logo;
    opens nl.rotterdam.nl_design_system.wicket.components.page_body;
    opens nl.rotterdam.nl_design_system.wicket.components.page_footer;
    opens nl.rotterdam.nl_design_system.wicket.components.page_header;
    opens nl.rotterdam.nl_design_system.wicket.components.page_layout;
    opens nl.rotterdam.nl_design_system.wicket.components;
    opens nl.rotterdam.nl_design_system.wicket.html;
    opens nl.rotterdam.nl_design_system.wicket.internal.components.button_border;




    requires org.apache.wicket.core;
    requires org.apache.wicket.util;
    requires org.danekja.jdk.serializable.functional;
    requires org.jspecify;

}