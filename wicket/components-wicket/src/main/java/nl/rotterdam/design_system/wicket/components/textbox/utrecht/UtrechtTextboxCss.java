package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtTextboxCss implements CssClassNames {

   DEFAULT("utrecht-textbox utrecht-textbox--html-input"),
   INVALID("utrecht-textbox--invalid"),
   DISABLED("utrecht-textbox--disabled");

   private final String classNames;

    @Override
    public @NonNull
    String getClassNames() {
        return classNames;
    }

    UtrechtTextboxCss(String classNames) {
       this.classNames = classNames;
   }
}
