package nl.rotterdam.nl_design_system.wicket.components.icon;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Add Utrecht Icon Behavior to an HTML component.
 */
public class RdIconBehavior extends TagNameClassComponentBehavior<RdIconBorder> {

    /**
     * Singleton instance.
     */
    public static final RdIconBehavior INSTANCE = new RdIconBehavior();

    private RdIconBehavior() {
        super("span", RdIconCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdIconBehavior.class, "@utrecht/icon/dist/index.min.css"));
    }

}
