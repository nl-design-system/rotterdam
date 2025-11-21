package nl.rotterdam.nl_design_system.docs.wicket;

import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.alert.AlertExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.body.BodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.button.ButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.checkbox.CheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.css.DesignSystemTheme;
import nl.rotterdam.nl_design_system.docs.wicket.data_summary.DataSummaryExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.dialog.DialogExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.FormFieldTextInputExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading.HeadingExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon.IconExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon.RodsIconExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon_button.IconButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link.LinkExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link_list.LinkListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo.LogoExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.number_badge.NumberBadgeExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.ordered_list.OrderedListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_body.PageBodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_footer.PageFooterExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_layout.PageLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.paragraph.ParagraphExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.preserve_data.PreserveDataExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.root.RootExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.separator.SeparatorExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.side_nav.SideNavExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.unordered_list.UnorderedListExamplesPanel;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingTheme;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingThemeBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.LambdaChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ComponentsPage extends RotterdamBasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPage.class);
    private static final IModel<@Nullable RdSyntaxHighlightingTheme> NULL_MODEL = Model.of((RdSyntaxHighlightingTheme) null);
    private static final JavaScriptReferenceHeaderItem COMPONENTS_JS_HEADER_ITEM = JavaScriptHeaderItem.forReference(
        new JavaScriptResourceReference(ComponentsPage.class, "ComponentsPage.js")
    );

    private static Link<Void> createRefreshPageLink() {
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

        add(RdSyntaxHighlightingThemeBehavior.of(NULL_MODEL));

        // Add the component stories. You can add multiple components with just one add, making it easier to read.
        pageBody.add(
            new SideNavExamplesPanel("sideNavExamplesPanel"),
            new AlertExamplesPanel("alertExamplesPanel"),
            new BadgeListExamplesPanel("badgeListExamplesPanel"),
            new BodyExamplesPanel("bodyExamplesPanel").setVisible(false),
            new ButtonExamplesPanel("buttonExamplesPanel"),
            new IconButtonExamplesPanel("iconButtonExamplesPanel"),
            new ActionGroupExamplesPanel("actionGroupExamplesPanel").setVisible(false),
            new CodeBlockExamplesPanel("codeBlockExamplesPanel").setVisible(false),
            new ColumnLayoutExamplesPanel("columnLayoutExamplesPanel").setVisible(false),
            new CheckboxExamplesPanel("checkboxExamplesPanel").setVisible(false),
            new FormFieldCheckboxExamplesPanel("formFieldCheckboxExamplesPanel"),
            new FormFieldLabelExamplesPanel("formFieldLabelExamplesPanel").setVisible(false),
            new FormFieldTextInputExamplesPanel("formFieldTextInputExamplesPanel"),
            new DataSummaryExamplesPanel("dataSummaryExamplesPanel"),
            new HeadingExamplesPanel("headingExamplesPanel").setVisible(false),
            new HeadingGroupExamplesPanel("headingGroupExamplesPanel").setVisible(false)
        );

        pageBody.add(new IconExamplesPanel("iconExamplesPanel").setVisible(false));
        pageBody.add(new RodsIconExamplesPanel("rodsIconExamplesPanel").setVisible(false));
        pageBody.add(new RotterdamLogoImageExamplesPanel("rotterdamLogoImageExamplesPanel"));
        pageBody.add(new LinkExamplesPanel("linkExamplesPanel").setVisible(false));
        pageBody.add(new LinkListExamplesPanel("linkListExamplesPanel").setVisible(false));
        pageBody.add(new LogoExamplesPanel("logoExamplesPanel").setVisible(false));
        pageBody.add(new DialogExamplesPanel("dialogExamplesPanel"));
        pageBody.add(new NumberBadgeExamplesPanel("numberBadgeExamplesPanel").setVisible(false));
        pageBody.add(new OrderedListExamplesPanel("orderedListExamplesPanel").setVisible(false));
        pageBody.add(new PageBodyExamplesPanel("pageBodyExamplesPanel").setVisible(false));
        pageBody.add(new PageFooterExamplesPanel("pageFooterExamplesPanel").setVisible(false));
        pageBody.add(new PageLayoutExamplesPanel("pageLayoutExamplesPanel").setVisible(false));
        pageBody.add(new ParagraphExamplesPanel("paragraphExamplesPanel").setVisible(false));
        pageBody.add(new PreserveDataExamplesPanel("preserveDataExamplesPanel"));
        pageBody.add(new RootExamplesPanel("rootExamplesPanel").setVisible(false));
        pageBody.add(new SeparatorExamplesPanel("separatorExamplesPanel").setVisible(false));
        pageBody.add(new UnorderedListExamplesPanel("unorderedListExamplesPanel").setVisible(false));

        pageBody.add(createActiveThemeChoice());
        pageBody.add(createRefreshPageLink());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        COMPONENTS_JS_HEADER_ITEM.setType(JavaScriptReferenceType.MODULE);
        response.render(COMPONENTS_JS_HEADER_ITEM);
    }

    public ComponentsPage() {
        super("Componenten voor Apache Wicket");
    }
}
