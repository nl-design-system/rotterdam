package nl.rotterdam.wicket.docs;

import static css.DesignTokensWicketCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM;
import static css.WicketComponentsCssReferences.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public abstract class BasePage extends WebPage {

    public static final String TITLE_ID = "title";
    public static final CssReferenceHeaderItem DOCS_CSS_HEADER_ITEM = CssHeaderItem.forReference(
        new CssResourceReference(BasePage.class, "docs.css")
    );

    public BasePage() {
        super();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
        response.render(THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
        response.render(DOCS_CSS_HEADER_ITEM);
    }
}
