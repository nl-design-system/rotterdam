package nl.rotterdam.nl_design_system.wicket.components.heading_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * @see RdHeadingGroupBorder
 */
public class RdHeadingGroupBehavior extends TagNameClassComponentBehavior<RdHeadingGroupBorder> {

    /**
     * Singleton instance.
     */
    public static final RdHeadingGroupBehavior INSTANCE = new RdHeadingGroupBehavior();

    private RdHeadingGroupBehavior() {
        super("hgroup", RdHeadingGroupCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdHeadingGroupBehavior.class, "@utrecht/heading-group-css/dist/index.css"));
    }
}
