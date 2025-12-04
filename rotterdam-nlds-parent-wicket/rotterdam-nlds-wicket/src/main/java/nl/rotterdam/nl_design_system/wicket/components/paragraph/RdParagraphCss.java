package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdParagraphCss implements CssClassNames {
    BASE("nl-paragraph"),
    LEAD("nl-paragraph nl-paragraph--lead");

    private final String cssClassNames;

    RdParagraphCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
