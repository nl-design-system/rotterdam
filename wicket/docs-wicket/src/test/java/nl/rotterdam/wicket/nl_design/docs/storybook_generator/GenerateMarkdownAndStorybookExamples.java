package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import nl.rotterdam.wicket.docs.DocsApplication;
import nl.rotterdam.wicket.docs.heading.HeadingExamplesPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled // for now manually executed
public class GenerateMarkdownAndStorybookExamples {

    // Initialize WicketTester to make basic Wicket code have a {@link org.apache.wicket.ThreadContext}.
    WicketTester tester = new WicketTester(new DocsApplication());

    @Test
    void generateHeadingComponent() {
        new MarkdownDocumentationExamplesGenerator(
            HeadingExamplesPanel.class,
            "heading"
        ).generate();
    }
}
