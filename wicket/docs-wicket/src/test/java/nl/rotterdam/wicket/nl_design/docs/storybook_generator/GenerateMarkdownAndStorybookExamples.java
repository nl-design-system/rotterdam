package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.design_system.wicket.components.badge_list.utrecht.UtrechtBadgeListBorder;
import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.design_system.wicket.components.column_layout.utrecht.UtrechtColumnLayoutBorder;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabel;
import nl.rotterdam.design_system.wicket.components.heading.utrecht.UtrechtHeading;
import nl.rotterdam.design_system.wicket.components.heading_group.utrecht.UtrechtHeadingGroupBorder;
import nl.rotterdam.design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.design_system.wicket.components.icon.utrecht.UtrechtIconBorder;
import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.DocsApplication;
import nl.rotterdam.wicket.docs.alert.AlertExamplesPanel;
import nl.rotterdam.wicket.docs.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.wicket.docs.body.BodyExamplesPanel;
import nl.rotterdam.wicket.docs.button_group.ButtonGroupExamplesPanel;
import nl.rotterdam.wicket.docs.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.wicket.docs.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.wicket.docs.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import nl.rotterdam.wicket.docs.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.wicket.docs.html_content.HtmlContentExamplesPanel;
import nl.rotterdam.wicket.docs.icon.IconExamplesPanel;
import nl.rotterdam.wicket.docs.logo.UtrechtLogoExamplesPanel;
import nl.rotterdam.wicket.docs.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.wicket.docs.number_badge.UtrechtNumberBadgeExamplesPanel;
import nl.rotterdam.wicket.docs.page_body.UtrechtPageBodyExamplesPanel;
import nl.rotterdam.wicket.docs.page_footer.UtrechtPageFooterExamplesPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * How to update the documentation:
 *
 * <ol>
 *     <li>For each example panel, add a test method.</li>
 *     <li>In the ExamplesPanel.java, create a private method for each component annotated with
 *     {@link ComponentExample}.</li>
 *     <li>In the ExamplesPanel.html, add a <header></header> component to explain the general information. </li>
 *     <li>In the ExamplesPanel.html, for each example, add a section as shown in HeadingExamplesPanel. It must have
 *     header and code and has an optional explanation.</li>
 * </ol>
 */
@SuppressWarnings("NewClassNamingConvention") // we don't want it to run by default as it is not really a test.
// But having it as a test makes it easy to run one Panel in isolation.
public class GenerateMarkdownAndStorybookExamples {

    // Initialize WicketTester to make basic Wicket code have a {@link org.apache.wicket.ThreadContext}.
    WicketTester tester = new WicketTester(new DocsApplication());

    @Test
    void generateAlertComponent() {
        new MarkdownDocumentationExamplesGenerator(AlertExamplesPanel.class, UtrechtAlert.class, "alert").generate();
    }

    @Test
    void generateBadgeListComponent() {
        new MarkdownDocumentationExamplesGenerator(
            BadgeListExamplesPanel.class,
            UtrechtBadgeListBorder.class,
            "badge-list"
        ).generate();
    }

    @Test
    void generateBodyComponent() {
        new MarkdownDocumentationExamplesGenerator(BodyExamplesPanel.class, BodyExamplesPanel.class, "body").generate();
    }

    @Test
    void generateButtonGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ButtonGroupExamplesPanel.class,
            UtrechtButtonGroupBorder.class,
            "button-group"
        ).generate();
    }

    @Test
    void generateCodeBlockComponent() {
        new MarkdownDocumentationExamplesGenerator(
            CodeBlockExamplesPanel.class,
            UtrechtCodeBlock.class,
            "code-block"
        ).generate();
    }

    @Test
    void generateColumnLayoutComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ColumnLayoutExamplesPanel.class,
            UtrechtColumnLayoutBorder.class,
            "column-layout"
        ).generate();
    }

    @Test
    void generateFormFieldCheckboxComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldCheckboxExamplesPanel.class,
            UtrechtFormFieldCheckbox.class,
            "form-field-checkbox"
        ).generate();
    }

    @Test
    void generateFormFieldLabelComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldLabelExamplesPanel.class,
            UtrechtFormLabel.class,
            "form-field-label"
        ).generate();
    }

    @Test
    void generateHeadingComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingExamplesPanel.class,
            UtrechtHeading.class,
            "heading"
        ).generate();
    }

    @Test
    void generateHeadingGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingGroupExamplesPanel.class,
            UtrechtHeadingGroupBorder.class,
            "heading-group"
        ).generate();
    }

    @Test
    void generateHtmlContentComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HtmlContentExamplesPanel.class,
            UtrechtHtmlContentBorder.class,
            "html-content"
        ).generate();
    }

    @Test
    void generateRotterdamLogoImage() {
        new MarkdownDocumentationExamplesGenerator(
            RotterdamLogoImageExamplesPanel.class,
            RotterdamLogoImage.class,
            "rotterdam-logo-image"
        ).generate();
    }

    @Test
    void generateUtrechtLogo() {
        new MarkdownDocumentationExamplesGenerator(
            UtrechtLogoExamplesPanel.class,
            UtrechtLogoBorder.class,
            "utrecht-logo"
        ).generate();
    }

    @Test
    void generateUtrechtIcon() {
        new MarkdownDocumentationExamplesGenerator(
            IconExamplesPanel.class,
            UtrechtIconBorder.class,
            "utrecht-icon"
        ).generate();
    }

    @Test
    void generateUtrechtNumberBadge() {
        new MarkdownDocumentationExamplesGenerator(
            UtrechtNumberBadgeExamplesPanel.class,
            UtrechtNumberBadge.class,
            "utrecht-number-badge"
        ).generate();
    }

    @Test
    void generateUtrechtPageBody() {
        new MarkdownDocumentationExamplesGenerator(
            UtrechtPageBodyExamplesPanel.class,
            UtrechtPageBodyBorder.class,
            "utrecht-page-body"
        ).generate();
    }

    @Test
    void generateUtrechtPageFooter() {
        new MarkdownDocumentationExamplesGenerator(
            UtrechtPageFooterExamplesPanel.class,
            UtrechtPageFooterBorder.class,
            "utrecht-page-footer"
        ).generate();
    }

    @AfterEach
    void tearDown() {
        tester.destroy();
    }
}
