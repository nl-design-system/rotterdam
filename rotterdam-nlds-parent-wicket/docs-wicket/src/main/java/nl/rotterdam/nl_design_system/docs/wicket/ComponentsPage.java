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
import nl.rotterdam.nl_design_system.docs.wicket.fieldset.FieldsetExamplesPanel;
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
import nl.rotterdam.nl_design_system.docs.wicket.radio_button.RadioButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.radio_group.RadioGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.root.RootExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.separator.SeparatorExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.side_nav.RdSideNavExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.unordered_list.UnorderedListExamplesPanel;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingTheme;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingThemeBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
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

import static nl.rotterdam.nl_design_system.docs.wicket.css.NldsVoorbeeldGemeenteThemeCssReference.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM;

public class ComponentsPage extends RotterdamBasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPage.class);
    private static final IModel<@Nullable RdSyntaxHighlightingTheme> NULL_MODEL = Model.of((RdSyntaxHighlightingTheme) null);
    private static final JavaScriptReferenceHeaderItem RODS_STORY_CANVAS_JS_HEADER_ITEM;
    
    static {
        RODS_STORY_CANVAS_JS_HEADER_ITEM = JavaScriptHeaderItem.forReference(
            new JavaScriptResourceReference(ComponentsPage.class, "rods-story-canvas.js")
        );
        RODS_STORY_CANVAS_JS_HEADER_ITEM.setType(JavaScriptReferenceType.MODULE);
    }

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
    
    private DesignSystemTheme currentTheme = DesignSystemTheme.RODS;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdSyntaxHighlightingThemeBehavior.of(NULL_MODEL));

        // Add the component stories. You can add multiple components with just one add, making it easier to read.
        pageBody.add(
            new RdSideNavExamplesPanel("sideNavExamplesPanel"),
            new AlertExamplesPanel("alertExamplesPanel"),
            new BadgeListExamplesPanel("badgeListExamplesPanel"),
            new BodyExamplesPanel("bodyExamplesPanel"),
            new ButtonExamplesPanel("buttonExamplesPanel"),
            new IconButtonExamplesPanel("iconButtonExamplesPanel"),
            new ActionGroupExamplesPanel("actionGroupExamplesPanel"),
            new CodeBlockExamplesPanel("codeBlockExamplesPanel"),
            new ColumnLayoutExamplesPanel("columnLayoutExamplesPanel"),
            new CheckboxExamplesPanel("checkboxExamplesPanel"),
            new FieldsetExamplesPanel("fieldsetExamplesPanel"),
            new FormFieldCheckboxExamplesPanel("formFieldCheckboxExamplesPanel"),
            new FormFieldLabelExamplesPanel("formFieldLabelExamplesPanel"),
            new FormFieldTextInputExamplesPanel("formFieldTextInputExamplesPanel"),
            new DataSummaryExamplesPanel("dataSummaryExamplesPanel"),
            new HeadingExamplesPanel("headingExamplesPanel"),
            new HeadingGroupExamplesPanel("headingGroupExamplesPanel"),
            new IconExamplesPanel("iconExamplesPanel"),
            new RodsIconExamplesPanel("rodsIconExamplesPanel"),
            new RotterdamLogoImageExamplesPanel("rotterdamLogoImageExamplesPanel"),
            new LinkExamplesPanel("linkExamplesPanel"),
            new LinkListExamplesPanel("linkListExamplesPanel"),
            new LogoExamplesPanel("logoExamplesPanel"),
            new DialogExamplesPanel("dialogExamplesPanel"),
            new NumberBadgeExamplesPanel("numberBadgeExamplesPanel"),
            new OrderedListExamplesPanel("orderedListExamplesPanel"),
            new PageBodyExamplesPanel("pageBodyExamplesPanel"),
            new PageFooterExamplesPanel("pageFooterExamplesPanel"),
            new PageLayoutExamplesPanel("pageLayoutExamplesPanel"),
            new ParagraphExamplesPanel("paragraphExamplesPanel"),
            new PreserveDataExamplesPanel("preserveDataExamplesPanel"),
            new RadioButtonExamplesPanel("radioButtonExamplesPanel"),
            new RadioGroupExamplesPanel("radioGroupExamplesPanel"),
            new RootExamplesPanel("rootExamplesPanel"),
            new SeparatorExamplesPanel("separatorExamplesPanel"),
            new UnorderedListExamplesPanel("unorderedListExamplesPanel"),
    
            createActiveThemeChoice(),
            createRefreshPageLink()
        );
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(RODS_STORY_CANVAS_JS_HEADER_ITEM);
        response.render(THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
    }

    public ComponentsPage() {
        super("Componenten voor Apache Wicket");
    }

    private Component createActiveThemeChoice() {
        return new DropDownChoice<>(
            "activeTheme",
            themeModel,
            Arrays.stream(DesignSystemTheme.values()).toList(),
            new LambdaChoiceRenderer<>(DesignSystemTheme::getDisplayName, DesignSystemTheme::getThemeClassName)
        ).add(new OnChangeAjaxBehavior() {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                var currentThemeclassName = currentTheme.getThemeClassName();

                var newTheme = themeModel.getObject();
                var newThemeClassName = newTheme.getThemeClassName();
                currentTheme = newTheme;

                target.appendJavaScript("$('html').removeClass('" +
                    currentThemeclassName +
                    "').addClass('" +
                    newThemeClassName +
                    "');");
            }
        });
    }
}
