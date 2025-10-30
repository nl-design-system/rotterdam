package nl.rotterdam.nl_design_system.wicket.components.paragraph.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdParagraphCss implements CssClassNames {
    DEFAULT("utrecht-paragraph"),
    LEAD("utrecht-paragraph utrecht-paragraph--lead");

    private final String cssClassNames;

    RdParagraphCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
