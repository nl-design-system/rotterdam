package nl.rotterdam.design_system.wicket.components.attribute_appender;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;

public enum AttributeAppenders {
    ;

    /**
     * Shortcut method to append a CSS class to a component.
     * Prevents having to duplicate 'class' literal in code.
     */
    public static Behavior appendCssClassBehavior(String cssClass) {
        return new AttributeAppender("class", cssClass).setSeparator(" ");
    }
}
