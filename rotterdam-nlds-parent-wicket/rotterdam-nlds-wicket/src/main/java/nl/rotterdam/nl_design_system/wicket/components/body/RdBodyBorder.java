package nl.rotterdam.nl_design_system.wicket.components.body;

import org.apache.wicket.markup.html.border.Border;

/**
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-body--docs">Utrecht body</a> component.
 * TODO: decide if this is needed for all pages.
 * TODO: what is difference between body and page_body?
 */
public class RdBodyBorder extends Border {

    public RdBodyBorder(String id) {
        super(id);
        add(RdBodyBehavior.INSTANCE);
    }
}
