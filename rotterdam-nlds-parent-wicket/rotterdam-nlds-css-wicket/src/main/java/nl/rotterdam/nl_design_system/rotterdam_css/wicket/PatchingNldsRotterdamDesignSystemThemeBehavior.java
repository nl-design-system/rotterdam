package nl.rotterdam.nl_design_system.rotterdam_css.wicket;

import nl.rotterdam.nl_design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.nl_design_system.wicket.html.AfterJqueryJavaScriptContentHeaderItem;
import org.apache.wicket.behavior.Behavior;

import static nl.rotterdam.nl_design_system.rotterdam_css.wicket.NldsRotterdamDesignSystemThemeCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM;

/**
 * <p>
 * A 'patching' version of {@link NldsRotterdamDesignSystemThemeBehavior}. Attach this to a page or the top-level panel
 * of a page, if you cannot attach a component to which <code>NldsRotterdamDesignSystemThemeBehavior</code> can be
 * added, to <code>&lt;html&gt;</code>. This behavior will add the header item for the required CSS and a JavaScript
 * header item to add the required CSS class to <code>&lt;html&gt;</code>.
 * </p>
 * <p>
 * Only a single instance is needed. See {@link #INSTANCE}.
 * </p>
 */
public class PatchingNldsRotterdamDesignSystemThemeBehavior extends HeaderItemRenderingBehavior {

    public static final Behavior INSTANCE = new PatchingNldsRotterdamDesignSystemThemeBehavior();

    private PatchingNldsRotterdamDesignSystemThemeBehavior() {
        addHeaderItem(THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
        addHeaderItem(new AfterJqueryJavaScriptContentHeaderItem(
            "document.addEventListener('DOMContentLoaded', (event) => { $('html').addClass('"
                + NldsRotterdamDesignSystemThemeCss.BASE.getClassNames()
                + "'); })",
            "patchingRodsTheme"));
    }
}
