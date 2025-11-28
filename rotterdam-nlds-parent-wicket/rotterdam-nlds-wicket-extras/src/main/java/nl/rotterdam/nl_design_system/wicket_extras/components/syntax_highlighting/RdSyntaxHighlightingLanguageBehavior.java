package nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * <p>
 * Add the <a href="https://prismjs.com/">Prism</a> language class name and load the core and language-specific
 * JavaScript files, to enable syntax highlighting for a specific language. Must be used with <code>&lt;code&gt;</code>.
 * </p>
 * <p>
 * This will only add the class name and load the JavaScript files. {@link RdSyntaxHighlightingThemeBehavior} must be
 * used to load the desired theme.
 * </p>
 */
public class RdSyntaxHighlightingLanguageBehavior extends Behavior {

    private static final String CLASS_NAME_PREFIX = "language-";
    private static final JavaScriptReferenceHeaderItem PRISM_CORE_REFERENCE_HEADER_ITEM =
        JavaScriptHeaderItem.forReference(
            new JavaScriptResourceReference(
                RdSyntaxHighlightingLanguageBehavior.class,
                "prismjs/components/prism-core.min.js"),
            "javascript-prism-core");

    private final IModel<String> classNameModel;
    private final IModel<JavaScriptReferenceHeaderItem> languageJavascriptReferenceHeaderItemModel;

    public static RdSyntaxHighlightingLanguageBehavior of(IModel<RdSyntaxHighlightingLanguage> languageModel) {
        return new RdSyntaxHighlightingLanguageBehavior(languageModel.map(RdSyntaxHighlightingLanguage::getCode));
    }

    public static RdSyntaxHighlightingLanguageBehavior ofCode(IModel<String> languageCodeModel) {
        return new RdSyntaxHighlightingLanguageBehavior(languageCodeModel);
    }

    private static String getClassName(String languageCode) {
        return CLASS_NAME_PREFIX + languageCode;
    }

    private RdSyntaxHighlightingLanguageBehavior(IModel<String> languageCodeModel) {
        classNameModel = languageCodeModel.map(RdSyntaxHighlightingLanguageBehavior::getClassName);
        languageJavascriptReferenceHeaderItemModel = languageCodeModel.map(languageCode ->
            JavaScriptHeaderItem.forReference(
                new JavaScriptResourceReference(
                    RdSyntaxHighlightingLanguageBehavior.class,
                    "prismjs/components/prism-" + languageCode + ".min.js"),
                "javascript-prism-language-" + languageCode));
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(PRISM_CORE_REFERENCE_HEADER_ITEM);
        response.render(languageJavascriptReferenceHeaderItemModel.getObject());
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        tag.append("class", classNameModel.getObject(), " ");
    }

    @Override
    public void detach(Component component) {
        super.detach(component);

        classNameModel.detach();
        languageJavascriptReferenceHeaderItemModel.detach();
    }
}
