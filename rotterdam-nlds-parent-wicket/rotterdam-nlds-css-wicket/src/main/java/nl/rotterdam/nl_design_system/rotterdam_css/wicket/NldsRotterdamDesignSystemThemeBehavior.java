package nl.rotterdam.nl_design_system.rotterdam_css.wicket;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import static nl.rotterdam.nl_design_system.rotterdam_css.wicket.NldsRotterdamDesignSystemThemeCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM;

/**
 * Load and activate the RODS (Rotterdam Design System) theme for the current page.
 *
 * <p>Add this behavior {@link org.apache.wicket.markup.html.WebPage} of the BasePage of your application.</p>
 *
 * <p>Can be safely used also in applications using NL Design System only on a fraction of the pages, as all CSS classes
 * are scoped.</p>
 */
public class NldsRotterdamDesignSystemThemeBehavior extends TagNameClassComponentBehavior<Component> {

    public static final Behavior INSTANCE = new NldsRotterdamDesignSystemThemeBehavior();

    private NldsRotterdamDesignSystemThemeBehavior() {
        super("html", NldsRotterdamDesignSystemThemeCss.DEFAULT);
        addHeaderItem(THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
    }
}
