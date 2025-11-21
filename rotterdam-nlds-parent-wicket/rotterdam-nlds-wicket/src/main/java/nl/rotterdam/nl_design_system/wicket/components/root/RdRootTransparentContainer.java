package nl.rotterdam.nl_design_system.wicket.components.root;

import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

/**
 * <p>
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">Top component of page</a>.    
 * </p>
 */
public class RdRootTransparentContainer extends TransparentWebMarkupContainer {
    public RdRootTransparentContainer(String id) {
        super(id);
        
        add(RdRootBehavior.INSTANCE);
    }
}
