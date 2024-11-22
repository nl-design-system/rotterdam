package nl.rotterdam.wicket.docs;

import css.DesignSystemTheme;
import nl.rotterdam.design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.LambdaChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ComponentsPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPage.class);
    private static final JavaScriptReferenceHeaderItem COMPONENTS_JS_HEADER_ITEM = JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(ComponentsPage.class, "ComponentsPage.js"));

    private static Link<Void> createRefreshPgaeLink() {
        return new Link<>("refreshStatefulPageLink") {
            @Override
            public void onClick() {
                LOGGER.info("Link was clicked. Page url now has state. Gives ability to inspect HTML in different state.");
            }
        };
    }

    private static Component createActiveThemeChoice() {
        return new DropDownChoice<>("activeTheme",
            Model.of(DesignSystemTheme.RODS),
            Arrays.stream(DesignSystemTheme.values()).toList(),
            new LambdaChoiceRenderer<>(DesignSystemTheme::getDisplayName, DesignSystemTheme::getThemeClassName)
        )
            .setOutputMarkupId(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(
            // TODO set title using model in BasePage
            new Label(TITLE_ID, "ComponentsPage · Apache Wicket · Rotterdam Design System"),

            createActiveThemeChoice(),
            new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")),
            new HeadingExamplesPanel("headingComponents"),
            createRefreshPgaeLink()
        );
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(COMPONENTS_JS_HEADER_ITEM);
    }
}
