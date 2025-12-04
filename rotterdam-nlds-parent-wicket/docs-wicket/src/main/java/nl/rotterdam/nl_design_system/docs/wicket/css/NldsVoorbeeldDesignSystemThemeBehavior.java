package nl.rotterdam.nl_design_system.docs.wicket.css;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import static nl.rotterdam.nl_design_system.docs.wicket.css.NldsVoorbeeldGemeenteThemeCssReference.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM;

/**
 * <p>
 * Load and activate the example municipality theme for the current page.    
 * </p>
 * <p>
 * Add this behavior to the component for the <code>&lt;html&gt;</code> tag of the base page(s) of the application. The
 * component will most likely be an
 * {@link nl.rotterdam.nl_design_system.wicket.components.root.RdRootTransparentContainer RdRootTransparentContainer}.
 * </p>
 * <p>
 * Can be safely used in applications using NL Design System on only a fraction of the pages, as all CSS classes are
 * scoped.
 * </p>
 */
public class NldsVoorbeeldDesignSystemThemeBehavior extends TagNameClassComponentBehavior<Component> {

    public static final Behavior INSTANCE = new NldsVoorbeeldDesignSystemThemeBehavior();

    private NldsVoorbeeldDesignSystemThemeBehavior() {
        super("html", NldsVoorbeeldDesignSystemThemeCss.BASE);
        addHeaderItem(THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
    }
}
