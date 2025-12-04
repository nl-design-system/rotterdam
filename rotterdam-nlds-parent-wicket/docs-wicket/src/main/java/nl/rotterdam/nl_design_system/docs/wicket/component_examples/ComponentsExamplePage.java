package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.ProjectRootResolver;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamBasePage;
import nl.rotterdam.nl_design_system.docs.wicket.css.BootstrapGridCssReference;
import nl.rotterdam.nl_design_system.wicket.components.code_block.RdCodeBlock;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavRecord;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguage;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguageBehavior;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingTheme;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingThemeBehavior;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.exception.UncheckedIllegalAccessException;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.string.Strings;
import org.jspecify.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Strings.CI;

public class ComponentsExamplePage extends RotterdamBasePage {

    public static final String ID_EXAMPLE_RENDERED = "example-rendered";
    public static final String PAGE_PARAM_COMPONENT = "component";
    public static final String ID_COMPONENT_SELECTION = "component-selection";
    private static final IModel<@Nullable RdSyntaxHighlightingTheme> NULL_MODEL = Model.of((RdSyntaxHighlightingTheme) null);
    private final String activeComponentExampleName;
    private final ExamplesPanel activeExample;
    private final File exampleSourceDirectory;

    public ComponentsExamplePage(PageParameters parameters) throws IOException {
        super("Componenten voorbeelden");
        activeComponentExampleName = getExampleName(parameters);

        activeExample = newExampleComponentRenderingComponent();

        var docsWicketModuleRoot = ProjectRootResolver.resolveProjectRootDir(ComponentsExamplePage.class);
        Class<? extends ExamplesPanel> exampleClassName = activeExample.getClass();

        var examplePackageDirectory = exampleClassName.getPackageName().replace(".", "/");

        exampleSourceDirectory = new File(docsWicketModuleRoot + "/src/main/java/" + examplePackageDirectory).getCanonicalFile();

        Validate.isTrue(exampleSourceDirectory.isDirectory(), "Source directory %s must be present", exampleSourceDirectory.getCanonicalPath());
    }

    private static String getExampleName(PageParameters parameters) {
        String component = parameters.get(PAGE_PARAM_COMPONENT).toOptionalString();
        if (!Strings.isEmpty(component)) {
            return component;
        }
        return ComponentExamplePanels.classes.getFirst().getSimpleName();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdSyntaxHighlightingThemeBehavior.of(NULL_MODEL));

        pageBody.add(
            newComponentSelectionSidebar(),
            activeExample,
            newComponentMarkupCode(),
            newComponentJavaCode()
        );
    }

    private Component newComponentMarkupCode() {
        RdCodeBlock codeBlock = new RdCodeBlock("markup-code", Model.of(resolveComponentHtmlCode()));
        codeBlock.getCodeComponent().add(RdSyntaxHighlightingLanguageBehavior.of(Model.of(RdSyntaxHighlightingLanguage.MARKUP)));
        codeBlock.setMarkupId("markup-code");
        return codeBlock;
    }

    private Component newComponentJavaCode() {
        RdCodeBlock codeBlock = new RdCodeBlock("java-code", Model.of(resolveComponentJavaCode()));
        codeBlock.getCodeComponent().add(RdSyntaxHighlightingLanguageBehavior.of(Model.of(RdSyntaxHighlightingLanguage.JAVA)));
        codeBlock.setMarkupId("java-code");
        return codeBlock;
    }

    private String resolveComponentHtmlCode() {

        var fullPath = new File(exampleSourceDirectory, activeExample.getClass().getSimpleName() + ".html");

        Validate.isTrue(fullPath.exists(), "Example HTML not found in path: %s", fullPath.getAbsolutePath());

        try {
            return new String(Files.readBytes(fullPath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String resolveComponentJavaCode() {

        var fullPath = new File(exampleSourceDirectory, activeExample.getClass().getSimpleName() + ".java");

        Validate.isTrue(fullPath.exists(), "Source directory %s does not exist", fullPath);

        try {
            return new String(Files.readBytes(fullPath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    private ExamplesPanel newExampleComponentRenderingComponent() {
        return ComponentExamplePanels
            .classes
            .stream()
            .filter(p -> p.getSimpleName().equals(activeComponentExampleName))
            .findFirst()
            .map(ComponentsExamplePage::instantiateExamplesPanel).orElseThrow();
    }

    private static ExamplesPanel instantiateExamplesPanel(Class<? extends ExamplesPanel> clazz) {
        try {
            return clazz.getConstructor(String.class)
                .newInstance(ID_EXAMPLE_RENDERED);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new UncheckedIllegalAccessException(e);
        }
    }

    private Component newComponentSelectionSidebar() {
        List<RdSideNavRecord> records =
            ComponentExamplePanels
                .classes
                .stream().map(clazz ->
                    new RdSideNavRecord(
                        null,
                        makeLabel(clazz),
                        ComponentsExamplePage.class,
                        new PageParameters(getPageParameters()).set(PAGE_PARAM_COMPONENT, clazz.getSimpleName()),
                        null,
                        null
                    )
                )
                .toList();

        return new RdSideNavPanel(ID_COMPONENT_SELECTION, records);
    }

    /***
     * Makes the label; package private for testing purpose.
     *
     * @return  the label.
     */
    static String makeLabel(Class<? extends ExamplesPanel> clazz) {
        String label = clazz.getSimpleName();

        // remove suffix
        label = CI.removeEnd(label, "ExamplesPanel");

        //ActionGroup > Action Group
        label = label.replaceAll("([a-z])([A-Z])", "$1 $2");

        return label;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(BootstrapGridCssReference.BOOTSTRAP_GRID_CSS);

        response.render(OnDomReadyHeaderItem.forScript(
            //language=JavaScript
            """
                const stylesheet = new CSSStyleSheet();
                
                // noinspection JSIgnoredPromiseFromCall
                stylesheet.replace(`
                .rods-story-canvas {
                  background-color: white;
                  border-color: rgb(0 0 0 / 10%);
                  border-radius: 4px;
                  border-style: solid;
                  border-width: 1px;
                  box-shadow: rgb(0 0 0 / 10%) 0 1px 3px 0;
                  margin-block-end: 40px;
                  margin-block-start: 25px;
                  padding-block-end: 30px;
                  padding-block-start: 30px;
                  padding-inline-end: 20px;
                  padding-inline-start: 20px;
                  position: relative;
                }`);
                
                class RodsStoryElement extends HTMLElement {
                  static name = 'rods-story-canvas';
                
                  static define = (registry = customElements) => registry.define(RodsStoryElement.name, RodsStoryElement);
                
                  constructor() {
                    super();
                  }
                
                  connectedCallback() {
                    const shadow = this.attachShadow({ mode: 'closed' });
                    shadow.adoptedStyleSheets = [stylesheet];
                    const template = this.querySelector('template');
                    const div = this.ownerDocument.createElement('div');
                    div.appendChild(this.ownerDocument.createElement('slot'));
                    div.classList.add('rods-story-canvas');
                    shadow.appendChild(div);
                    if (template) {
                      this.appendChild(template.content.cloneNode(true));
                    }
                  }
                }
                RodsStoryElement.define();
                """));
    }
}
