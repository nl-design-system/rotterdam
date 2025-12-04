package nl.rotterdam.nl_design_system.docs.wicket.storybook_generator;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.DocsApplication;
import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.alert.AlertExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.body.BodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.button.ButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.checkbox.CheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.data_summary.DataSummaryExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.dialog.DialogExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.FormFieldTextInputExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading.HeadingExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon.IconExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon_button.IconButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo.LogoExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.number_badge.NumberBadgeExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.ordered_list.OrderedListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_body.PageBodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_footer.PageFooterExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_layout.PageLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.preserve_data.PreserveDataExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.radio_button.RadioButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.root.RootExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.separator.SeparatorExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.text_input.TextInputExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.unordered_list.UnorderedListExamplesPanel;
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
    final WicketTester tester = new WicketTester(new DocsApplication());

    @Test
    void generateAlertComponent() {
        new MarkdownDocumentationExamplesGenerator(AlertExamplesPanel.class, "alert", "Alert").generate();
    }

    @Test
    void generateBadgeListComponent() {
        tester.startComponentInPage(BadgeListExamplesPanel.class);
        String renderedHtml = tester.getLastResponseAsString();

        new MarkdownDocumentationExamplesGenerator(
            BadgeListExamplesPanel.class,
            "badge-list",
            "Badge List",
            renderedHtml
        ).generate();
    }

    @Test
    void generateBodyComponent() {
        new MarkdownDocumentationExamplesGenerator(BodyExamplesPanel.class, "body", "Body").generate();
    }

    @Test
    void generateButtonComponent() {
        new MarkdownDocumentationExamplesGenerator(ButtonExamplesPanel.class, "button", "Button").generate();
    }

    @Test
    void generateIconButtonComponent() {
        new MarkdownDocumentationExamplesGenerator(IconButtonExamplesPanel.class, "iconButton", "Icon Button").generate();
    }

    @Test
    void generateActionGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ActionGroupExamplesPanel.class,
            "action-group",
            "Action Group"
        ).generate();
    }

    @Test
    void generateCheckboxComponent() {
        new MarkdownDocumentationExamplesGenerator(CheckboxExamplesPanel.class, "checkbox", "Checkbox").generate();
    }

    @Test
    void generateCodeBlockComponent() {
        new MarkdownDocumentationExamplesGenerator(CodeBlockExamplesPanel.class, "code-block", "Code Block").generate();
    }

    @Test
    void generateColumnLayoutComponent() {
        new MarkdownDocumentationExamplesGenerator(
            ColumnLayoutExamplesPanel.class,
            "column-layout",
            "Column Layout"
        ).generate();
    }

    @Test
    void generateDataSummaryComponent() {
        new MarkdownDocumentationExamplesGenerator(
            DataSummaryExamplesPanel.class,
            "data-summary",
            "Data Summary"
        ).generate();
    }

    @Test
    void generateFormFieldCheckboxComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldCheckboxExamplesPanel.class,
            "form-field-checkbox",
            "Form Field Checkbox"
        ).generate();
    }

    @Test
    void generateFormFieldLabelComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldLabelExamplesPanel.class,
            "form-field-label",
            "Form Field Label"
        ).generate();
    }

    @Test
    void generateFormFieldTextInputComponent() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldTextInputExamplesPanel.class,
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
            "heading",
            "Heading",
            renderedHtml
        ).generate();
    }

    @Test
    void generateHeadingGroupComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingGroupExamplesPanel.class,
            "heading-group",
            "Heading Group"
        ).generate();
    }

    @Test
    void generateRotterdamLogoImage() {
        new MarkdownDocumentationExamplesGenerator(
            RotterdamLogoImageExamplesPanel.class,
            "rotterdam-logo-image",
            "Rotterdam Logo Image"
        ).generate();
    }

    @Test
    void generateTextInputComponent() {
        new MarkdownDocumentationExamplesGenerator(TextInputExamplesPanel.class, "text input", "Text Input").generate();
    }

    @Test
    void generateLogo() {
        new MarkdownDocumentationExamplesGenerator(LogoExamplesPanel.class, "logo", "Logo").generate();
    }

    @Test
    void generateIcon() {
        new MarkdownDocumentationExamplesGenerator(IconExamplesPanel.class, "icon", "Icon").generate();
    }

    @Test
    void generateDialog() {
        new MarkdownDocumentationExamplesGenerator(DialogExamplesPanel.class, "dialog", "Dialog (and Modal Dialog)").generate();
    }

    @Test
    void generateNumberBadge() {
        new MarkdownDocumentationExamplesGenerator(
            NumberBadgeExamplesPanel.class,
            "number-badge",
            "Number Badge"
        ).generate();
    }

    @Test
    void generatePageBody() {
        new MarkdownDocumentationExamplesGenerator(PageBodyExamplesPanel.class, "page-body", "Page Body").generate();
    }

    @Test
    void generatePageFooter() {
        new MarkdownDocumentationExamplesGenerator(
            PageFooterExamplesPanel.class,
            "page-footer",
            "Page Footer"
        ).generate();
    }

    @Test
    void generatePageLayout() {
        new MarkdownDocumentationExamplesGenerator(
            PageLayoutExamplesPanel.class,
            "page-layout",
            "Page Layout"
        ).generate();
    }

    @Test
    void generatePreserveData() {
        new MarkdownDocumentationExamplesGenerator(
            PreserveDataExamplesPanel.class,
            "preserve-data",
            "Preserve Data"
        ).generate();
    }

    @Test
    void generateRadioButton() {
        new MarkdownDocumentationExamplesGenerator(RadioButtonExamplesPanel.class, "radio-button", "Radio Button").generate();
    }

    @Test
    void generateRoot() {
        new MarkdownDocumentationExamplesGenerator(RootExamplesPanel.class, "root", "Root").generate();
    }

    @Test
    void generateSeparator() {
        new MarkdownDocumentationExamplesGenerator(SeparatorExamplesPanel.class, "separator", "Separator").generate();
    }

    @Test
    void generateFormFieldTextInput() {
        new MarkdownDocumentationExamplesGenerator(
            FormFieldTextInputExamplesPanel.class,
            "form-field-text-input",
            "Form Field Text Input"
        ).generate();
    }

    @Test
    void generateOrderedList() {
        new MarkdownDocumentationExamplesGenerator(
            OrderedListExamplesPanel.class,
            "ordered-list",
            "Ordered List"
        ).generate();
    }

    @Test
    void generateUnorderedList() {
        new MarkdownDocumentationExamplesGenerator(
            UnorderedListExamplesPanel.class,
            "unordered-list",
            "Unordered List"
        ).generate();
    }

    @AfterEach
    void tearDown() {
        tester.destroy();
    }
}
