package nl.rotterdam.nl_design_system.wicket.components.text_area;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdTextAreaCss implements CssClassNames {
    BASE("utrecht-textarea"),
    INVALID("utrecht-textarea--invalid"),
    DISABLED("utrecht-textarea--disabled"),
    READ_ONLY("utrecht-textarea--readonly");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdTextAreaCss(String classNames) {
        this.classNames = classNames;
    }
}
