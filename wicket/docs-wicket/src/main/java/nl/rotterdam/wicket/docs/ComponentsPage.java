package nl.rotterdam.wicket.docs;

import css.DesignSystemTheme;
import nl.rotterdam.wicket.docs.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.wicket.docs.alert.AlertExamplesPanel;
import nl.rotterdam.wicket.docs.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.wicket.docs.body.BodyExamplesPanel;
import nl.rotterdam.wicket.docs.button.ButtonExamplesPanel;
import nl.rotterdam.wicket.docs.checkbox.CheckboxExamplesPanel;
import nl.rotterdam.wicket.docs.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.wicket.docs.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.data_summary.DataSummaryExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_text_input.FormFieldTextInputExamplesPanel;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import nl.rotterdam.wicket.docs.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.wicket.docs.html_content.HtmlContentExamplesPanel;
import nl.rotterdam.wicket.docs.icon.IconExamplesPanel;
import nl.rotterdam.wicket.docs.icon.RodsIconExamplesPanel;
import nl.rotterdam.wicket.docs.link.LinkExamplesPanel;
import nl.rotterdam.wicket.docs.link_list.LinkListExamplesPanel;
import nl.rotterdam.wicket.docs.logo.LogoExamplesPanel;
import nl.rotterdam.wicket.docs.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.wicket.docs.number_badge.NumberBadgeExamplesPanel;
import nl.rotterdam.wicket.docs.ordered_list.OrderedListExamplesPanel;
import nl.rotterdam.wicket.docs.page_body.PageBodyExamplesPanel;
import nl.rotterdam.wicket.docs.page_footer.PageFooterExamplesPanel;
import nl.rotterdam.wicket.docs.page_layout.PageLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.paragraph.utrecht.ParagraphExamplesPanel;
import nl.rotterdam.wicket.docs.preserve_data.PreserveDataExamplesPanel;
import nl.rotterdam.wicket.docs.root.RootExamplesPanel;
import nl.rotterdam.wicket.docs.separator.SeparatorExamplesPanel;
import nl.rotterdam.wicket.docs.side_nav.DenhaagSideNavExamplesPanel;
import nl.rotterdam.wicket.docs.unordered_list.UnorderedListExamplesPanel;
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
            new ButtonExamplesPanel("buttonExamplesPanel"),
            new ActionGroupExamplesPanel("actionGroupExamplesPanel"),
            new CodeBlockExamplesPanel("codeBlockExamplesPanel"),
            new ColumnLayoutExamplesPanel("columnLayoutExamplesPanel"),
            new CheckboxExamplesPanel("checkboxExamplesPanel"),
            new FormFieldCheckboxExamplesPanel("formFieldCheckboxExamplesPanel"),
            new FormFieldLabelExamplesPanel("formFieldLabelExamplesPanel"),
            new FormFieldTextInputExamplesPanel("formFieldTextInputExamplesPanel"),
            new DataSummaryExamplesPanel("dataSummaryExamplesPanel"),
            new HeadingExamplesPanel("headingExamplesPanel"),
            new HeadingGroupExamplesPanel("headingGroupExamplesPanel")
        );

        pageBody.add(new HtmlContentExamplesPanel("htmlContentExamplesPanel"));
        pageBody.add(new IconExamplesPanel("iconExamplesPanel"));
        pageBody.add(new RodsIconExamplesPanel("rodsIconExamplesPanel"));
        pageBody.add(new RotterdamLogoImageExamplesPanel("rotterdamLogoImageExamplesPanel"));
        pageBody.add(new LinkExamplesPanel("linkExamplesPanel"));
        pageBody.add(new LinkListExamplesPanel("linkListExamplesPanel"));
        pageBody.add(new LogoExamplesPanel("logoExamplesPanel"));
        pageBody.add(new NumberBadgeExamplesPanel("numberBadgeExamplesPanel"));
        pageBody.add(new OrderedListExamplesPanel("orderedListExamplesPanel"));
        pageBody.add(new PageBodyExamplesPanel("pageBodyExamplesPanel"));
        pageBody.add(new PageFooterExamplesPanel("pageFooterExamplesPanel"));
        pageBody.add(new PageLayoutExamplesPanel("pageLayoutExamplesPanel"));
        pageBody.add(new ParagraphExamplesPanel("paragraphExamplesPanel"));
        pageBody.add(new PreserveDataExamplesPanel("preserveDataExamplesPanel"));
        pageBody.add(new RootExamplesPanel("rootExamplesPanel"));
        pageBody.add(new SeparatorExamplesPanel("separatorExamplesPanel"));
        pageBody.add(new UnorderedListExamplesPanel("unorderedListExamplesPanel"));

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
