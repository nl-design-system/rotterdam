package nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import com.github.openjson.JSONTokener;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

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
    private static final Map<String, JavaScriptReferenceHeaderItem> JAVASCRIPT_REFERENCE_HEADER_ITEM_BY_LANGUAGE_CODE = new HashMap<>();
    private static final Map<String, List<JavaScriptReferenceHeaderItem>> TRANSITIVE_JAVASCRIPT_REFERENCE_HEADER_ITEMS_BY_LANGUAGE_CODE;
    
    static {
        TRANSITIVE_JAVASCRIPT_REFERENCE_HEADER_ITEMS_BY_LANGUAGE_CODE = new HashMap<>();
        try (var componentsInput = Objects.requireNonNull(RdSyntaxHighlightingLanguageBehavior.class.getResourceAsStream("prismjs/components.json"));
             var componentsReader = new InputStreamReader(componentsInput, UTF_8)) {
            var components = new JSONObject(new JSONTokener(componentsReader));
            var languages = components.getJSONObject("languages");
            var languageKeysIterator = languages.keys();
            while (languageKeysIterator.hasNext()) {
                var languageCode = languageKeysIterator.next();
                if (!languageCode.equals("meta")) {
                    var language = languages.getJSONObject(languageCode);

                    var transitiveJavascriptHeaderItems = new ArrayList<JavaScriptReferenceHeaderItem>();
                    TRANSITIVE_JAVASCRIPT_REFERENCE_HEADER_ITEMS_BY_LANGUAGE_CODE.put(languageCode, transitiveJavascriptHeaderItems);
                    var alreadyAddedLanguageCodes = new HashSet<String>();
                    gatherExtendedLanguages(language, languages, transitiveJavascriptHeaderItems, alreadyAddedLanguageCodes);
                    transitiveJavascriptHeaderItems.add(createHeaderItemForLanguageIfNeeded(languageCode));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void gatherExtendedLanguages(JSONObject language, JSONObject languages, List<JavaScriptReferenceHeaderItem> transitiveHeaderItems, HashSet<String> alreadyAddedLanguageCodes) {
        if (language.has("require")) {
            var require = language.get("require");
            if (require instanceof String languageCode) {
                gatherExtendedLanguages(languages.getJSONObject(languageCode), languages, transitiveHeaderItems, alreadyAddedLanguageCodes);
                if (!alreadyAddedLanguageCodes.contains(languageCode)) {
                    alreadyAddedLanguageCodes.add(languageCode);
                    transitiveHeaderItems.add(createHeaderItemForLanguageIfNeeded(languageCode));
                }
            } else if (require instanceof JSONArray requiresAsArray) {
                requiresAsArray.forEach(languageCodeAsObject -> {
                    var languageCode = (String) languageCodeAsObject;
                    gatherExtendedLanguages(languages.getJSONObject(languageCode), languages, transitiveHeaderItems, alreadyAddedLanguageCodes);
                    if (!alreadyAddedLanguageCodes.contains(languageCode)) {
                        alreadyAddedLanguageCodes.add(languageCode);
                        transitiveHeaderItems.add(createHeaderItemForLanguageIfNeeded(languageCode));
                    }
                });
            } else {
                throw new IllegalStateException("Unknown type for 'require': " + require.getClass().getName());
            }
        }
    }

    private static JavaScriptReferenceHeaderItem createHeaderItemForLanguageIfNeeded(String languageCode) {
        return JAVASCRIPT_REFERENCE_HEADER_ITEM_BY_LANGUAGE_CODE.computeIfAbsent(languageCode, code ->
            JavaScriptHeaderItem.forReference(
                new JavaScriptResourceReference(
                    RdSyntaxHighlightingLanguageBehavior.class,
                    "prismjs/components/prism-" + code + ".min.js"),
                "javascript-prism-language-" + code));
    }

    private final IModel<String> languageCodeModel;
    private final IModel<String> classNameModel;

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
        this.languageCodeModel = languageCodeModel;
        classNameModel = languageCodeModel.map(RdSyntaxHighlightingLanguageBehavior::getClassName);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(PRISM_CORE_REFERENCE_HEADER_ITEM);
        
        TRANSITIVE_JAVASCRIPT_REFERENCE_HEADER_ITEMS_BY_LANGUAGE_CODE.get(languageCodeModel.getObject())
            .forEach(response::render);
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
    }
}
