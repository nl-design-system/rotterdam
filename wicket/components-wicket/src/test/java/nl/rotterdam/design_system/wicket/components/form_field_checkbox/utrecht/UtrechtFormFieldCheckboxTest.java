package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTester;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UtrechtFormFieldCheckboxTest {


    @BeforeEach
    void setUp() {
        assertWicketThreadStarted();
    }

    @Test
    void verifyHtmlForBasicExample() {

        // from https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field-checkbox--docs#label
        // with minimal changes:
        // - attribute ordening
        // - added id attributes; wicket ajax needs them
        // - set input name the way wicket needs them.
        // language=HTML
        var htmlFromReference = """ 
        <div id="utrecht-checkbox-field" class="utrecht-form-field utrecht-form-field--checkbox">
          <p class="utrecht-form-field__label utrecht-form-field__label--checkbox">
            <label
              class="utrecht-form-label utrecht-form-label--checkbox"
              for="checkbox-sample"
            >
              <input
                type="checkbox"
                name="static:component:label:checkbox"
                id="checkbox-sample"
                class="utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom utrecht-form-field__input"
              />
              Ik ga akkoord met de algemene voorwaarden
            </label>
          </p>
        </div>""";


        UtrechtFormFieldCheckbox component = new UtrechtFormFieldCheckbox(
            "component",
            Model.of(false),
            "Ik ga akkoord met de algemene voorwaarden"
        );

        setSubjectUnderTestIds(component);

        String actualRenderedMarkup = ComponentRenderer.renderComponent(new UtrechtFormFieldCheckboxTestPanel(component)).toString();

        assertEquals(formatTidy(htmlFromReference), formatTidy(actualRenderedMarkup));
    }

    private void setSubjectUnderTestIds(UtrechtFormFieldCheckbox component) {
        component.setMarkupId("utrecht-checkbox-field");
        component.getCheckbox().setMarkupId("checkbox-sample");
    }

    private static String formatTidy(String htmlWithOneContainerElement) {
        Element renderedElement = Jsoup.parseBodyFragment(htmlWithOneContainerElement).body().firstElementChild();
        Objects.requireNonNull(renderedElement, "There must be an element");
        return renderedElement.toString();
    }

    private static void assertWicketThreadStarted() {
        new WicketTester(new ComponentsWicketTestApplication());
    }
}