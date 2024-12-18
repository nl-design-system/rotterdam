package nl.rotterdam.wicket.docs;

import css.DesignSystemTheme;
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
import nl.rotterdam.wicket.docs.icon.RodsIconExamplesPanel;
import nl.rotterdam.wicket.docs.link.UtrechtLinkExamplesPanel;
import nl.rotterdam.wicket.docs.link_list.UtrechtLinkListExamplesPanel;
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
import nl.rotterdam.wicket.docs.side_nav.DenhaagSideNavExamplesPanel;
import nl.rotterdam.wicket.docs.unordered_list.UtrechtUnorderedListExamplesPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.LambdaChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ComponentsPage extends RotterdamBasePage {

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

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Add the component stories. You can add multiple components with just one add, making it easier to read.
        pageBody.add(
            new DenhaagSideNavExamplesPanel("denhaagSideNavExamplesPanel"),
            new AlertExamplesPanel("alertExamplesPanel"),
            new BadgeListExamplesPanel("badgeListExamplesPanel"),
            new BodyExamplesPanel("bodyExamplesPanel"),
            new UtrechtButtonExamplesPanel("buttonExamplesPanel"),
            new ButtonGroupExamplesPanel("buttonGroupExamplesPanel"),
            new CodeBlockExamplesPanel("codeBlockExamplesPanel"),
            new ColumnLayoutExamplesPanel("columnLayoutExamplesPanel"),
            new FormFieldCheckboxExamplesPanel("formFieldCheckboxExamplesPanel"),
            new FormFieldLabelExamplesPanel("formFieldLabelExamplesPanel"),
            new UtrechtFormFieldTextboxExamplesPanel("formFieldTextboxExamplesPanel"),
            new HeadingExamplesPanel("headingExamplesPanel"),
            new HeadingGroupExamplesPanel("headingGroupExamplesPanel")
        );

        pageBody.add(new HtmlContentExamplesPanel("htmlContentExamplesPanel"));
        pageBody.add(new IconExamplesPanel("iconExamplesPanel"));
        pageBody.add(new RodsIconExamplesPanel("rodsIconExamplesPanel"));
        pageBody.add(new RotterdamLogoImageExamplesPanel("rotterdamLogoImageExamplesPanel"));
        pageBody.add(new UtrechtLinkExamplesPanel("linkExamplesPanel"));
        pageBody.add(new UtrechtLinkListExamplesPanel("linkListExamplesPanel"));
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

        pageBody.add(createActiveThemeChoice());
        pageBody.add(createRefreshPgaeLink());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        COMPONENTS_JS_HEADER_ITEM.setType(JavaScriptReferenceType.MODULE);
        response.render(COMPONENTS_JS_HEADER_ITEM);
    }

    public ComponentsPage() {
        super();
        this.pageTitle = "Componenten voor Apache Wicket";
    }
}
