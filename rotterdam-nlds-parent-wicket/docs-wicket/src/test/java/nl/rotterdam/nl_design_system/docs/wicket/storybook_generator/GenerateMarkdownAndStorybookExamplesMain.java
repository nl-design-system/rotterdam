package nl.rotterdam.nl_design_system.docs.wicket.storybook_generator;

import java.io.PrintWriter;

import ch.qos.logback.classic.LoggerContext;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.slf4j.LoggerFactory;

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

        if (!summary.getFailures().isEmpty()) {
            summary.getFailures().forEach(failure ->
                System.err.println("Failure: " + failure.getTestIdentifier().getDisplayName() + " failure: " + failure.getException()));
            throw  new RuntimeException("Markdown generation failed, there are the following failures");
        }

        shutdownLogback();

        System.out.println("Completed storybook generation");

    }

    private static void shutdownLogback() {
        if (LoggerFactory.getILoggerFactory() instanceof LoggerContext context) {
            context.stop();
        }
    }

}
