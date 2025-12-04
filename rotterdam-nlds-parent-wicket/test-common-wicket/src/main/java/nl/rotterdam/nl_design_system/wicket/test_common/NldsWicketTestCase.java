package nl.rotterdam.nl_design_system.wicket.test_common;

import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NldsWicketTestCase extends WicketTestCase {
    private static final Set<String> TOKEN_SET_ATTRIBUTE_KEYS = Set.of("aria-describedby", "class");

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
        document.select("*").forEach(element -> {
            var originalAttributes = new ArrayList<>(element.attributes().asList());
            originalAttributes.sort(Comparator.comparing(Attribute::namespace).thenComparing(Attribute::localName));
            element.clearAttributes();
            originalAttributes.forEach(attribute -> element.attributes().add(attribute.getKey(), sortIfTokenSet(attribute)));
        });
        Element renderedElement = document.body().firstElementChild();
        Objects.requireNonNull(renderedElement, "There must be an element");
        return renderedElement.toString();
    }

    private static String sortIfTokenSet(Attribute attribute) {
        return TOKEN_SET_ATTRIBUTE_KEYS.contains(attribute.getKey())
            ? Arrays.stream(attribute.getValue().split(" +")).filter(token -> !token.isEmpty()).sorted().collect(Collectors.joining(" "))
            : attribute.getValue();
    }

    protected static String formatTidyBody(String htmlWithOneContainerElement) {
        Document document = Jsoup.parseBodyFragment(htmlWithOneContainerElement);
        document.outputSettings().prettyPrint(true).indentAmount(4);
        Element renderedElement = document.body();
        Objects.requireNonNull(renderedElement, "There must be an element");
        return renderedElement.toString();
    }

    /**
     * Asserts that two HTML fragments are semantically the same, ignoring differences in formatting, whitespace, the
     * order of attributes and the order of tokens in a token set attribute.
     */
    protected static void assertHtmlFragmentSame(String expectedHtmlFragment, String actualHtmlFragment) {
        assertEquals(formatTidy(expectedHtmlFragment), formatTidy(actualHtmlFragment));
    }

    protected static void assertHtmlFragmentBodySame(String expectedHtmlFragment, String actualHtmlFragment) {
        assertEquals(formatTidyBody(expectedHtmlFragment), formatTidyBody(actualHtmlFragment));
    }
}
