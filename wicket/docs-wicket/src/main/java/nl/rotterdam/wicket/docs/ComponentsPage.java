package nl.rotterdam.wicket.docs;

import css.DesignSystemTheme;
import java.util.Arrays;
import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.design_system.wicket.components.page_header.utrecht.UtrechtPageHeaderBorder;
import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.wicket.docs.alert.AlertExamplesPanel;
import nl.rotterdam.wicket.docs.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.wicket.docs.body.BodyExamplesPanel;
import nl.rotterdam.wicket.docs.button.UtrechtButtonExamplesPanel;
import nl.rotterdam.wicket.docs.button_group.ButtonGroupExamplesPanel;
import nl.rotterdam.wicket.docs.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.wicket.docs.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_textbox.UtrechtFormFieldTextboxExamplesPanel;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import nl.rotterdam.wicket.docs.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.wicket.docs.html_content.HtmlContentExamplesPanel;
import nl.rotterdam.wicket.docs.icon.IconExamplesPanel;
import nl.rotterdam.wicket.docs.link.UtrechtLinkExamplesPanel;
import nl.rotterdam.wicket.docs.logo.UtrechtLogoExamplesPanel;
import nl.rotterdam.wicket.docs.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.wicket.docs.number_badge.UtrechtNumberBadgeExamplesPanel;
import nl.rotterdam.wicket.docs.ordered_list.UtrechtOrderedListExamplesPanel;
import nl.rotterdam.wicket.docs.page_body.UtrechtPageBodyExamplesPanel;
import nl.rotterdam.wicket.docs.page_footer.UtrechtPageFooterExamplesPanel;
import nl.rotterdam.wicket.docs.page_layout.UtrechtPageLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.paragraph.utrecht.UtrechtParagraphExamplesPanel;
import nl.rotterdam.wicket.docs.preserve_data.UtrechtPreserveDataExamplesPanel;
import nl.rotterdam.wicket.docs.root.UtrechtRootExamplesPanel;
import nl.rotterdam.wicket.docs.separator.UtrechtSeparatorExamplesPanel;
import nl.rotterdam.wicket.docs.unordered_list.UtrechtUnorderedListExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.LambdaChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentsPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPage.class);
    private static final JavaScriptReferenceHeaderItem COMPONENTS_JS_HEADER_ITEM = JavaScriptHeaderItem.forReference(
        new JavaScriptResourceReference(ComponentsPage.class, "ComponentsPage.js")
    );

    private static Link<Void> createRefreshPgaeLink() {
        return new Link<>("refreshStatefulPageLink") {
            @Override
            public void onClick() {
                LOGGER.info(
                    "Link was clicked. Page url now has state. Gives ability to inspect HTML in different state."
                );
            }
        };
    }

    private static Component createActiveThemeChoice() {
        return new DropDownChoice<>(
            "activeTheme",
            Model.of(DesignSystemTheme.RODS),
            Arrays.stream(DesignSystemTheme.values()).toList(),
            new LambdaChoiceRenderer<>(DesignSystemTheme::getDisplayName, DesignSystemTheme::getThemeClassName)
        ).setOutputMarkupId(true);
    }

    private UtrechtPageLayoutBorder pageLayout;
    private UtrechtPageHeaderBorder pageHeader;
    private UtrechtPageBodyBorder pageBody;
    private UtrechtPageFooterBorder pageFooter;
    private UtrechtLogoBorder logo;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Build up the page layout
        pageLayout = new UtrechtPageLayoutBorder("utrechtPageLayout");
        add(pageLayout);

        pageHeader = new UtrechtPageHeaderBorder("utrechtPageHeader");
        pageLayout.add(pageHeader);

        logo = new UtrechtLogoBorder("utrechtLogo");
        pageHeader.add(logo);

        logo.add(new RotterdamLogoImage("rotterdamLogoImage"));

        pageBody = new UtrechtPageBodyBorder("utrechtPageBody");
        pageLayout.add(pageBody);

        pageFooter = new UtrechtPageFooterBorder("utrechtPageFooter");
        pageLayout.add(pageFooter);

        // Add the component stories
        pageBody.add(new AlertExamplesPanel("alertExamplesPanel"));
        pageBody.add(new BadgeListExamplesPanel("badgeListExamplesPanel"));
        pageBody.add(new BodyExamplesPanel("bodyExamplesPanel"));
        pageBody.add(new UtrechtButtonExamplesPanel("buttonExamplesPanel"));
        pageBody.add(new ButtonGroupExamplesPanel("buttonGroupExamplesPanel"));
        pageBody.add(new CodeBlockExamplesPanel("codeBlockExamplesPanel"));
        pageBody.add(new ColumnLayoutExamplesPanel("columnLayoutExamplesPanel"));
        pageBody.add(new FormFieldCheckboxExamplesPanel("formFieldCheckboxExamplesPanel"));
        pageBody.add(new FormFieldLabelExamplesPanel("formFieldLabelExamplesPanel"));
        pageBody.add(new UtrechtFormFieldTextboxExamplesPanel("formFieldTextboxExamplesPanel"));
        pageBody.add(new HeadingExamplesPanel("headingExamplesPanel"));
        pageBody.add(new HeadingGroupExamplesPanel("headingGroupExamplesPanel"));
        pageBody.add(new HtmlContentExamplesPanel("htmlContentExamplesPanel"));
        pageBody.add(new IconExamplesPanel("iconExamplesPanel"));
        pageBody.add(new RotterdamLogoImageExamplesPanel("rotterdamLogoImageExamplesPanel"));
        pageBody.add(new UtrechtLinkExamplesPanel("linkExamplesPanel"));
        pageBody.add(new UtrechtLogoExamplesPanel("logoExamplesPanel"));
        pageBody.add(new UtrechtNumberBadgeExamplesPanel("numberBadgeExamplesPanel"));
        pageBody.add(new UtrechtOrderedListExamplesPanel("orderedListExamplesPanel"));
        pageBody.add(new UtrechtPageBodyExamplesPanel("pageBodyExamplesPanel"));
        pageBody.add(new UtrechtPageFooterExamplesPanel("pageFooterExamplesPanel"));
        pageBody.add(new UtrechtPageLayoutExamplesPanel("pageLayoutExamplesPanel"));
        pageBody.add(new UtrechtParagraphExamplesPanel("paragraphExamplesPanel"));
        pageBody.add(new UtrechtPreserveDataExamplesPanel("preserveDataExamplesPanel"));
        pageBody.add(new UtrechtRootExamplesPanel("rootExamplesPanel"));
        pageBody.add(new UtrechtSeparatorExamplesPanel("separatorExamplesPanel"));
        pageBody.add(new UtrechtUnorderedListExamplesPanel("unorderedListExamplesPanel"));

        add(
            // TODO set title using model in BasePage
            new Label(TITLE_ID, "ComponentsPage · Apache Wicket · Rotterdam Design System")
        );

        pageBody.add(createActiveThemeChoice());
        pageBody.add(createRefreshPgaeLink());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        COMPONENTS_JS_HEADER_ITEM.setType(JavaScriptReferenceType.MODULE);
        response.render(COMPONENTS_JS_HEADER_ITEM);
    }

    public ComponentsPage() {}
}
