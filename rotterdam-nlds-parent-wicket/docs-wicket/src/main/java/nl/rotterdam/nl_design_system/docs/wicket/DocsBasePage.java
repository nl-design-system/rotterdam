package nl.rotterdam.nl_design_system.docs.wicket;

import static nl.rotterdam.nl_design_system.docs.wicket.css.NldsVoorbeeldGemeenteThemeCssReference.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM;

import nl.rotterdam.nl_design_system.rotterdam_css.wicket.ActivateNldsRotterdamDesignSystemThemeBehavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public abstract class DocsBasePage extends WebPage {

    public static final CssReferenceHeaderItem DOCS_CSS_HEADER_ITEM = CssHeaderItem.forReference(
        new CssResourceReference(DocsBasePage.class, "docs.css")
    );

    public DocsBasePage() {
        super();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(ActivateNldsRotterdamDesignSystemThemeBehavior.INSTANCE);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
        response.render(DOCS_CSS_HEADER_ITEM);
    }
}
