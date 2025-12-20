package nl.rotterdam.nl_design_system.wicket.components.page_number_navigation;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Intended for internal use, do not use it from your library or application
 */
public class PageNumberNavigationBehavior extends TagNameClassComponentBehavior<WebMarkupContainer> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        PageNumberNavigationBehavior.class,
        "@utrecht/pagination-css/dist/index.min.css"
    );
    private PageNumberNavigationBehavior() {
        super("nav", PageNumberNavigationCssClassnames.BASE);

        addHeaderItem(CSS_HEADER_ITEM);
    }




}
