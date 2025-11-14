package nl.rotterdam.nl_design_system.wicket.components.css_class_names;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.jspecify.annotations.NonNull;

/**
 * Defines CSS class names and work with them in a typesafe way.
 */
public interface CssClassNames {

    /**
     * Gives the class name or class names
     * @return class names, multiple classes seperated by space
     */
    @NonNull
    String getClassNames();

    /**
     * Append them to the 'class' attribute in the tag.
     * @param tag to append the css classnames to
     */
    default void appendTo(ComponentTag tag) {
        tag.append("class", getClassNames(), " ");
    }

    /**
     * Use the CSS Classes as {@link AttributeAppender}.
     * @return the class as appender
     */
    default Behavior asBehavior() {
        return new AttributeAppender("class", getClassNames()).setSeparator(" ");
    }
}
