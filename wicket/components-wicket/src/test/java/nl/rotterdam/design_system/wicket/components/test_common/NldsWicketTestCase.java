package nl.rotterdam.design_system.wicket.components.test_common;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import nl.rotterdam.design_system.wicket.components.form_field.NlFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NldsWicketTestCase extends WicketTestCase {

    @Override
    protected WebApplication newApplication() {
        return new ComponentsWicketTestApplication();
    }

    protected void verifyUtrechtFormFieldContract(NlFormField component, String actualOutput) {
        Component utrechtFormField = (Component) component;

        // assert root has utrecht-form-field class
        TagTester tester = TagTester.createTagByAttribute(actualOutput, "id", utrechtFormField.getMarkupId());
        assertThat(tester.getAttribute("class")).contains(UtrechtFormFieldCss.DEFAULT.getClassNames());

        // assert label is present, as label has no id we just assert full content
        assertThat(actualOutput).contains(UtrechtFormFieldCss.DEFAULT.getClassNames());

        // TODO there is more to validate here.
    }

    protected static String renderFormFieldComponentInTestPanel(NlFormField component) {
        return ComponentRenderer.renderComponent(new FormComponentTestPanel((Component) component)).toString();
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

    /**
     * Asserts that two HTML fragments are the same, ignoring differences in formatting and whitespace.
     */
    protected static void assertHtmlFragmentSame(String expectedHtmlFragment, String actualHtmlFragment) {
        // TODO: ignore attribute order, css class order
        assertEquals(formatTidy(expectedHtmlFragment), formatTidy(actualHtmlFragment));
    }

    protected static void assertHasCss(TagTester fieldTag, CssClassNames cssClassNames) {
        assertThat(fieldTag.getAttribute("class"))
            .contains(cssClassNames.getClassNames());
    }


}
