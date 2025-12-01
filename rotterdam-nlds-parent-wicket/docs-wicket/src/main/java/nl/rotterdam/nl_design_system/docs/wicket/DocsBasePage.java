package nl.rotterdam.nl_design_system.docs.wicket;

import nl.rotterdam.nl_design_system.docs.wicket.css.DesignSystemTheme;
import nl.rotterdam.nl_design_system.docs.wicket.css.NldsModelDesignSystemThemeBehavior;
import nl.rotterdam.nl_design_system.wicket.components.body.RdBodyTransparentContainer;
import nl.rotterdam.nl_design_system.wicket.components.root.RdRootTransparentContainer;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public abstract class DocsBasePage extends WebPage {

    public static final CssReferenceHeaderItem DOCS_CSS_HEADER_ITEM =
        cssReferenceHeaderItem(DocsBasePage.class, "docs.css");
    
    protected IModel<DesignSystemTheme> themeModel = Model.of(DesignSystemTheme.RODS);

    public DocsBasePage() {
        super();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            new RdRootTransparentContainer("root").add(
                new NldsModelDesignSystemThemeBehavior(themeModel)),
            new RdBodyTransparentContainer("body"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(DOCS_CSS_HEADER_ITEM);
    }
}
