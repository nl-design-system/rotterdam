package nl.rotterdam.design_system.wicket.components.test_common;

import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTestCase;
import org.assertj.core.api.Assertions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Objects;

import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.UTRECHT_FORM_FIELD_CLASSNAME;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.UTRECHT_FORM_LABEL;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class NldsWicketTestCase extends WicketTestCase {

    @Override
    protected WebApplication newApplication() {
        return new ComponentsWicketTestApplication();
    }

    protected void verifyUtrechtFormFieldContract(UtrechtFormField component, String actualOutput) {
        Component utrechtFormField = (Component) component;

        // assert root has utrecht-form-field class
        TagTester tester = TagTester.createTagByAttribute(actualOutput, "id", utrechtFormField.getMarkupId());
        assertThat(tester.getAttribute("class")).contains(UTRECHT_FORM_FIELD_CLASSNAME);

        // assert label is present, as label has no id yet we just assert full content
        assertThat(actualOutput).contains(UTRECHT_FORM_LABEL);

        // TODO there is more to validate here.
    }

    protected static String renderComponentInTestPanel(Component component) {
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
