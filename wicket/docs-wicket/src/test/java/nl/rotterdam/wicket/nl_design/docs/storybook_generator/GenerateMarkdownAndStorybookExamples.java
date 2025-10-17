package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.design_system.wicket.components.badge_list.utrecht.UtrechtBadgeListBorder;
import nl.rotterdam.design_system.wicket.components.action_group.RdActionGroup;
import nl.rotterdam.design_system.wicket.components.button.RdButton;
import nl.rotterdam.design_system.wicket.components.checkbox.RdCheckbox;
import nl.rotterdam.design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.design_system.wicket.components.column_layout.utrecht.UtrechtColumnLayoutBorder;
import nl.rotterdam.design_system.wicket.components.data_summary.RdDataSummary;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.RdFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.form_field_text_input.RdFormFieldTextInput;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabel;
import nl.rotterdam.design_system.wicket.components.heading.utrecht.UtrechtHeading;
import nl.rotterdam.design_system.wicket.components.heading_group.utrecht.UtrechtHeadingGroupBorder;
import nl.rotterdam.design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.design_system.wicket.components.icon.utrecht.UtrechtIconBorder;
import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.design_system.wicket.components.number_badge.utrecht.UtrechtNumberBadge;
import nl.rotterdam.design_system.wicket.components.ordered_list.utrecht.UtrechtOrderedList;
import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataLabel;
import nl.rotterdam.design_system.wicket.components.root.utrecht.UtrechtRootBorder;
import nl.rotterdam.design_system.wicket.components.separator.utrecht.UtrechtSeparator;
import nl.rotterdam.design_system.wicket.components.text_input.RdTextInput;
import nl.rotterdam.design_system.wicket.components.unordered_list.utrecht.UtrechtUnorderedList;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.DocsApplication;
import nl.rotterdam.wicket.docs.alert.AlertExamplesPanel;
import nl.rotterdam.wicket.docs.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.wicket.docs.body.BodyExamplesPanel;
import nl.rotterdam.wicket.docs.action_group.ActionGroupExamplesPanel;
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
import nl.rotterdam.wicket.docs.logo.LogoExamplesPanel;
import nl.rotterdam.wicket.docs.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.wicket.docs.number_badge.NumberBadgeExamplesPanel;
import nl.rotterdam.wicket.docs.ordered_list.OrderedListExamplesPanel;
import nl.rotterdam.wicket.docs.page_body.PageBodyExamplesPanel;
import nl.rotterdam.wicket.docs.page_footer.PageFooterExamplesPanel;
import nl.rotterdam.wicket.docs.page_layout.PageLayoutExamplesPanel;
import nl.rotterdam.wicket.docs.preserve_data.PreserveDataExamplesPanel;
import nl.rotterdam.wicket.docs.root.RootExamplesPanel;
import nl.rotterdam.wicket.docs.separator.SeparatorExamplesPanel;
import nl.rotterdam.wicket.docs.text_input.TextInputExamplesPanel;
import nl.rotterdam.wicket.docs.unordered_list.UnorderedListExamplesPanel;
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
        new MarkdownDocumentationExamplesGenerator(
            AlertExamplesPanel.class,
            UtrechtAlert.class,
            "alert",
            "Alert"
        ).generate();
    }

    @Test
    void generateBadgeListComponent() {
        tester.startComponentInPage(BadgeListExamplesPanel.class);
        String renderedHtml = tester.getLastResponseAsString();

        new MarkdownDocumentationExamplesGenerator(
            BadgeListExamplesPanel.class,
            UtrechtBadgeListBorder.class,
            "badge-list",
            "Badge List",
            renderedHtml
        ).generate();
    }

    @Test
    void generateBodyComponent() {
        new MarkdownDocumentationExamplesGenerator(
            BodyExamplesPanel.class,
            BodyExamplesPanel.class,
            "body",
            "Body"
        ).generate();
    }

    @Test
    void generateButtonComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ButtonExamplesPanel.class,
            RdButton.class,
            "button",
            "Button"
        ).generate();
    }

    @Test
    void generateActionGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ActionGroupExamplesPanel.class,
            RdActionGroup.class,
            "action-group",
            "Action Group"
        ).generate();
    }

    @Test
    void generateCheckboxComponent() {
        new MarkdownDocumentationExamplesGenerator(
            CheckboxExamplesPanel.class,
            RdCheckbox.class,
            "checkbox",
            "Checkbox"
        ).generate();
    }

    @Test
    void generateCodeBlockComponent() {
        new MarkdownDocumentationExamplesGenerator(
            CodeBlockExamplesPanel.class,
            UtrechtCodeBlock.class,
            "code-block",
            "Code Block"
        ).generate();
    }

    @Test
    void generateColumnLayoutComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ColumnLayoutExamplesPanel.class,
            UtrechtColumnLayoutBorder.class,
            "column-layout",
            "Column Layout"
        ).generate();
    }

    @Test
    void generateDataSummaryComponent() {
        new MarkdownDocumentationExamplesGenerator(
            DataSummaryExamplesPanel.class,
            RdDataSummary.class,
            "data-summary",
            "Data Summary"
        ).generate();

    }

    @Test
    void generateFormFieldCheckboxComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldCheckboxExamplesPanel.class,
            RdFormFieldCheckbox.class,
            "form-field-checkbox",
            "Form Field Checkbox"
        ).generate();
    }

    @Test
    void generateFormFieldLabelComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldLabelExamplesPanel.class,
            UtrechtFormLabel.class,
            "form-field-label",
            "Form Field Label"
        ).generate();
    }

    @Test
    void generateFormFieldTextInputComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldTextInputExamplesPanel.class,
            RdFormFieldTextInput.class,
            "form-field-text-input",
            "Form Field Text Input"
        ).generate();
    }

    @Test
    void generateHeadingComponent() {
        tester.startComponentInPage(HeadingExamplesPanel.class);
        String renderedHtml = tester.getLastResponseAsString();

        new MarkdownDocumentationExamplesGenerator(
            HeadingExamplesPanel.class,
            UtrechtHeading.class,
            "heading",
            "Heading",
            renderedHtml
        ).generate();
    }

    @Test
    void generateHeadingGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingGroupExamplesPanel.class,
            UtrechtHeadingGroupBorder.class,
            "heading-group",
            "Heading Group"
        ).generate();
    }

    @Test
    void generateHtmlContentComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HtmlContentExamplesPanel.class,
            UtrechtHtmlContentBorder.class,
            "html-content",
            "HTML Content"
        ).generate();
    }

    @Test
    void generateRotterdamLogoImage() {
        new MarkdownDocumentationExamplesGenerator(
            RotterdamLogoImageExamplesPanel.class,
            RotterdamLogoImage.class,
            "rotterdam-logo-image",
            "Rotterdam Logo Image"
        ).generate();
    }

    @Test
    void generateTextInputComponent() {
        new MarkdownDocumentationExamplesGenerator(
            TextInputExamplesPanel.class,
            RdTextInput.class,
            "text input",
            "Text Input"
        ).generate();
    }

    @Test
    void generateLogo() {
        new MarkdownDocumentationExamplesGenerator(
            LogoExamplesPanel.class,
            UtrechtLogoBorder.class,
            "logo",
            "Logo"
        ).generate();
    }

    @Test
    void generateIcon() {
        new MarkdownDocumentationExamplesGenerator(
            IconExamplesPanel.class,
            UtrechtIconBorder.class,
            "icon",
            "Icon"
        ).generate();
    }

    @Test
    void generateNumberBadge() {
        new MarkdownDocumentationExamplesGenerator(
            NumberBadgeExamplesPanel.class,
            UtrechtNumberBadge.class,
            "number-badge",
            "Number Badge"
        ).generate();
    }

    @Test
    void generatePageBody() {
        new MarkdownDocumentationExamplesGenerator(
            PageBodyExamplesPanel.class,
            UtrechtPageBodyBorder.class,
            "page-body",
            "Page Body"
        ).generate();
    }

    @Test
    void generatePageFooter() {
        new MarkdownDocumentationExamplesGenerator(
            PageFooterExamplesPanel.class,
            UtrechtPageFooterBorder.class,
            "page-footer",
            "Page Footer"
        ).generate();
    }

    @Test
    void generatePageLayout() {
        new MarkdownDocumentationExamplesGenerator(
            PageLayoutExamplesPanel.class,
            UtrechtPageLayoutBorder.class,
            "page-layout",
            "Page Layout"
        ).generate();
    }

    @Test
    void generatePreserveData() {
        new MarkdownDocumentationExamplesGenerator(
            PreserveDataExamplesPanel.class,
            UtrechtPreserveDataLabel.class,
            "preserve-data",
            "Preserve Data"
        ).generate();
    }

    @Test
    void generateRoot() {
        new MarkdownDocumentationExamplesGenerator(
            RootExamplesPanel.class,
            UtrechtRootBorder.class,
            "root",
            "Root"
        ).generate();
    }

    @Test
    void generateSeparator() {
        new MarkdownDocumentationExamplesGenerator(
            SeparatorExamplesPanel.class,
            UtrechtSeparator.class,
            "separator",
            "Separator"
        ).generate();
    }


    @Test
    void generateFormFieldTextInput() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldTextInputExamplesPanel.class,
            RdFormFieldTextInput.class,
            "form-field-text-input",
            "Form Field Text Input"
        ).generate();
    }



    @Test
    void generateOrderedList() {
        new MarkdownDocumentationExamplesGenerator(
            OrderedListExamplesPanel.class,
            UtrechtOrderedList.class,
            "ordered-list",
            "Ordered List"
        ).generate();
    }

    @Test
    void generateUnorderedList() {
        new MarkdownDocumentationExamplesGenerator(
            UnorderedListExamplesPanel.class,
            UtrechtUnorderedList.class,
            "unordered-list",
            "Unordered List"
        ).generate();
    }

    @AfterEach
    void tearDown() {
        tester.destroy();
    }
}
