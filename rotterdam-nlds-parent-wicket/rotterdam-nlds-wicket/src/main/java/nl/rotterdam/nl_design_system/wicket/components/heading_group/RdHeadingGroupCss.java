package nl.rotterdam.nl_design_system.wicket.components.heading_group;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdHeadingGroupCss implements CssClassNames {
    DEFAULT("utrecht-heading-group");

    private final String classNames;

    RdHeadingGroupCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
