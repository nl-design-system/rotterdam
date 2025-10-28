package nl.rotterdam.nl_design_system.wicket.test_common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class NldsWicketTestCase extends WicketTestCase {

    @Override
    protected WebApplication newApplication() {
        return new ComponentsWicketTestApplication();
    }

    protected static String renderComponentInDivTestPanel(Component component) {
        return ComponentRenderer.renderComponent(new DivComponentTestPanel(component)).toString();
    }

    protected static String renderComponentInDlTestPanel(Component component) {
        return ComponentRenderer.renderComponent(new DlComponentTestPanel(component)).toString();
    }

    protected static String formatTidy(String htmlWithOneContainerElement) {
        Document document = Jsoup.parseBodyFragment(htmlWithOneContainerElement);
        document.outputSettings().prettyPrint(true).indentAmount(4);
        Element renderedElement = document.body().firstElementChild();
        Objects.requireNonNull(renderedElement, "There must be an element");
        return renderedElement.toString();
    }

    /**
     * Asserts that two HTML fragments are the same, ignoring differences in formatting and whitespace.
     */
    protected static void assertHtmlFragmentSame(String expectedHtmlFragment, String actualHtmlFragment) {
        // TODO: ignore attribute order, css class order
        assertEquals(formatTidy(expectedHtmlFragment), formatTidy(actualHtmlFragment));
    }
}
