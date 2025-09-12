package nl.rotterdam.design_system.wicket.components.test_common;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Objects;

public abstract class NldsWicketTestCase extends WicketTestCase {

    @Override
    protected WebApplication newApplication() {
        return new ComponentsWicketTestApplication();
    }

    protected static String renderComponentInTestPanel(Panel component) {
        return ComponentRenderer.renderComponent(new FormComponentTestPanel(component)).toString();
    }

    protected static String formatTidy(String htmlWithOneContainerElement) {
        Document document = Jsoup.parseBodyFragment(htmlWithOneContainerElement);
        document.outputSettings()
            .prettyPrint(true)
            .indentAmount(4);
        Element renderedElement = document.body().firstElementChild();
        Objects.requireNonNull(renderedElement, "There must be an element");
        return renderedElement.toString();
    }


}
