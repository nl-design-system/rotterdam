package nl.rotterdam.wicket.nl_design.docs.storybook_generator;

import java.io.PrintWriter;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class GenerateMarkdownAndStorybookExamplesMain {

    public static void main(String[] args) {
        // Create a launcher request to discover tests
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(DiscoverySelectors.selectClass(GenerateMarkdownAndStorybookExamples.class)) // Specify the test class
            .build();

        // Create the Launcher
        Launcher launcher = LauncherFactory.create();

        // Add a listener for summary
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        // Execute the tests
        launcher.execute(request);

        // Print the summary
        TestExecutionSummary summary = listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        System.out.println("Completed storybook generation");
    }
}
