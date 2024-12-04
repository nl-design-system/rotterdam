package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.design_system.wicket.components.badge_list.utrecht.UtrechtBadgeListBorder;
import nl.rotterdam.design_system.wicket.components.heading.utrecht.UtrechtHeading;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.DocsApplication;
import nl.rotterdam.wicket.docs.alert.AlertExamplesPanel;
import nl.rotterdam.wicket.docs.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.wicket.docs.body.BodyExamplesPanel;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
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
    void generateHeadingComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingExamplesPanel.class,
            UtrechtHeading.class,
            "heading"
        ).generate();
    }

    @AfterEach
    void tearDown() {
        tester.destroy();
    }
}
