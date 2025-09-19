package nl.rotterdam.design_system.wicket.components.output_tag;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.WicketTag;

public class ComponentTagAssertions {
    public static void assertIsRegularHtmlTag(ComponentTag tag) {
        if (tag instanceof WicketTag) {
            throw new IllegalStateException("utrecht-form-field must be a regular HTML element, not a Wicket tag: " + tag);
        }
    }
}
