package nl.rotterdam.nl_design_system.wicket.components.html_content;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdHtmlContentCss implements CssClassNames {
    DEFAULT("utrecht-html");

    private final String classNames;

    RdHtmlContentCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
