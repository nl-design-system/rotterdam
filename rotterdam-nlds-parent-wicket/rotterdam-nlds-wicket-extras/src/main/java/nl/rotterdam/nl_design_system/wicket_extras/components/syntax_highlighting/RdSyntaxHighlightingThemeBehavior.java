package nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <p>
 * Add a CSS reference to the page header for the <a href="https://prismjs.com/">Prism</a> theme. This must be used. If
 * the default theme must be used, pass a model returning <code>null</code> to one of the factory methods.
 * </p>
 * <p>
 * This can be added to the highest possible component in the hierarchy, instead of adding it to each component using
 * syntax highlighting.
 * </p>
 * <p>
 * This will only add the theme CSS. To set the language for a specific <code>&lt;code&gt;</code> and load the
 * JavaScript files use {@link RdSyntaxHighlightingLanguageBehavior}.
 * </p>
 */
public class RdSyntaxHighlightingThemeBehavior extends Behavior {

    private final IModel<CssReferenceHeaderItem> themeCssReferenceHeaderItemModel;

    public static RdSyntaxHighlightingThemeBehavior of(IModel<@Nullable RdSyntaxHighlightingTheme> themeModel) {
        return new RdSyntaxHighlightingThemeBehavior(
            themeModel.map(RdSyntaxHighlightingTheme::getSuffix).orElse(""));
    }

    public static RdSyntaxHighlightingThemeBehavior ofCode(IModel<@Nullable String> themeCodeModel) {
        return new RdSyntaxHighlightingThemeBehavior(
            themeCodeModel.map(themeCode -> '-' + themeCode).orElse(""));
    }

    private RdSyntaxHighlightingThemeBehavior(IModel<String> themeSuffixModel) {
        this.themeCssReferenceHeaderItemModel = themeSuffixModel.map(themeSuffix -> cssReferenceHeaderItem(
            RdSyntaxHighlightingThemeBehavior.class,
            "prismjs/themes/prism" + themeSuffix + ".min.css"
        ));
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(themeCssReferenceHeaderItemModel.getObject());
    }

    @Override
    public void detach(Component component) {
        super.detach(component);

        themeCssReferenceHeaderItemModel.detach();
    }
}
