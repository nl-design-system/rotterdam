package nl.rotterdam.nl_design_system.wicket.components.css_class_names;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.jspecify.annotations.NonNull;

public interface CssClassNames {
    @NonNull
    String getClassNames(); // mag spaties bevatten (meerdere classes)

    default void appendTo(ComponentTag tag) {
        tag.append("class", getClassNames(), " ");
    }

    default Behavior asBehavior() {
        return new AttributeAppender("class", getClassNames()).setSeparator(" ");
    }
}
