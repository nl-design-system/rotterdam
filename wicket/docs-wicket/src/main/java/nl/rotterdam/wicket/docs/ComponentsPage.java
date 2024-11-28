package nl.rotterdam.wicket.docs;

import css.DesignSystemTheme;
import java.util.Arrays;
import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.design_system.wicket.components.column_layout.utrecht.UtrechtColumnLayoutBorder;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.heading_group.utrecht.UtrechtHeadingGroupBorder;
import nl.rotterdam.design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.design_system.wicket.components.icon.utrecht.UtrechtIconBorder;
import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import nl.rotterdam.design_system.wicket.components.ordered_list.utrecht.UtrechtOrderedList;
import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.design_system.wicket.components.page_header.utrecht.UtrechtPageHeaderBorder;
import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.design_system.wicket.components.separator.utrecht.UtrechtSeparator;
import nl.rotterdam.design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedList;
import nl.rotterdam.wicket.docs.form_label.FormLabelExamplesPanel;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import nl.rotterdam.wicket.docs.page_layout.PageLayoutExamplesPanel;
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
    private UtrechtOrderedList orderedList;
    private UtrechtUnorderedList unorderedList;
    private UtrechtLogoBorder logo;

    @Override
    protected void onInitialize() {
        super.onInitialize();
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

        pageBody.add(new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")));

        pageBody.add(new HeadingExamplesPanel("headingComponents"));
        // add(new HeadingPanel("labelComponents"));
        pageBody.add(new FormLabelExamplesPanel("labelComponents"));
        pageBody.add(new UtrechtHtmlContentBorder("utrechtHtmlContent"));
        pageBody.add(new UtrechtNumberBadge("utrechtNumberBadge", Model.of("42")));
        pageBody.add(
            new UtrechtAlert(
                "utrechtAlertInfo",
                Model.of(
                    "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
                )
            )
        );
        pageBody.add(
            new UtrechtAlert(
                "utrechtAlertWarning",
                Model.of(
                    "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
                )
            )
        );
        pageBody.add(
            new UtrechtAlert(
                "utrechtAlertAlert",
                Model.of(
                    "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
                )
            )
        );
        pageBody.add(
            new UtrechtAlert(
                "utrechtAlertOk",
                Model.of(
                    "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
                )
            )
        );
        pageBody.add(new UtrechtSeparator("utrechtSeparator"));
        pageBody.add(new UtrechtButtonGroupBorder("utrechtButtonGroup"));
        orderedList = new UtrechtOrderedList("utrechtOrderedList");
        pageBody.add(orderedList);

        unorderedList = new UtrechtUnorderedList("utrechtUnorderedList");
        pageBody.add(unorderedList);

        pageBody.add(new UtrechtIconBorder("utrechtIcon"));
        pageBody.add(new UtrechtColumnLayoutBorder("utrechtColumnLayout"));
        pageBody.add(new UtrechtHeadingGroupBorder("utrechtHeadingGroup"));
        pageBody.add(
            new UtrechtFormFieldCheckbox(
                "utrechtFormFieldCheckbox",
                Model.of(false),
                Model.of("I agree"),
                Model.of("Description"),
                Model.of("error")
            )
        );
        // pageBody.add(
        //     new WebMarkupContainer("utrechtOrderedList2") {
        //         @Override
        //         protected void onInitialize() {
        //             super.onInitialize();
        //             add(new UtrechtOrderedListBehavior());
        //         }
        //     }
        // );

        // RepeatingView listItems = new RepeatingView("utrechtOrderedListItem");
        // listItems.add(new Label(listItems.newChildId(), "green"));
        // listItems.add(new Label(listItems.newChildId(), "blue"));
        // listItems.add(new Label(listItems.newChildId(), "red"));

        // pageLayout.add(new PageLayoutExamplesPanel("pageLayoutExamples"));

        add(
            // TODO set title using model in BasePage
            new Label(TITLE_ID, "ComponentsPage · Apache Wicket · Rotterdam Design System")
        );

        pageBody.add(createActiveThemeChoice());
        pageBody.add(createRefreshPgaeLink());
        // pageBody.add(
        // new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")),
        // new HeadingExamplesPanel("headingComponents")
        // );
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(COMPONENTS_JS_HEADER_ITEM);
    }

    // private final UtrechtOrderedListItem orderedListItem;

    public ComponentsPage() {}
}
