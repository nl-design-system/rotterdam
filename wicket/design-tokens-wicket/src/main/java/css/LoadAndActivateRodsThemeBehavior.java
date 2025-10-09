package css;

import static css.DesignTokensWicketCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Load and activate the RODS (Rotterdam Design System) theme for the current page.
 *
 * <p>Add this behavior {@link org.apache.wicket.markup.html.WebPage} of the BasePage of your application.</p>
 *
 * <p>Can be safely used also in applications using NL Design System only on a fraction of the pages, as all CSS classes
 * are scoped.</p>
 */
public class LoadAndActivateRodsThemeBehavior extends Behavior {

    public static final Behavior INSTANCE = new LoadAndActivateRodsThemeBehavior();

    private static final HeaderItem ACTIVATE_RODS_JAVASCRIPT = JavaScriptHeaderItem.forReference(
        new JavaScriptResourceReference(LoadAndActivateRodsThemeBehavior.class, "LoadAndActivateRodsThemeBehavior.js")
    );

    private LoadAndActivateRodsThemeBehavior() {
        // singleton
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        response.render(THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
        response.render(ACTIVATE_RODS_JAVASCRIPT);
    }
}
