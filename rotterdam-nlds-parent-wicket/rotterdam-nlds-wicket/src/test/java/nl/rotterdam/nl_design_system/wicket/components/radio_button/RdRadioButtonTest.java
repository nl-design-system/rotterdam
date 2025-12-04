package nl.rotterdam.nl_design_system.wicket.components.radio_button;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

class RdRadioButtonTest extends NldsWicketTestCase {

    @Test
    void uncheckedIsRenderedCorrectly() {
        var radioGroup = new RadioGroup<>("radioGroup", Model.of("not option1"));
        var radioButton = new RdRadioButton<>("radioButton", Model.of("option1"), radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radioButton'>"))
            .setMarkupId("radioButton");

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="radio"
                id="radioButton"
                name="radioGroup"
                value="radio0"
                class="utrecht-radio-button utrecht-radio-button--html-input"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioButton).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void checkedIsRenderedCorrectly() {
        var radioGroup = new RadioGroup<>("radioGroup", Model.of("option1"));
        var radioButton = new RdRadioButton<>("radioButton", Model.of("option1"), radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radioButton'>"))
            .setMarkupId("radioButton");

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="radio"
                id="radioButton"
                name="radioGroup"
                value="radio0"
                checked=""
                class="utrecht-radio-button utrecht-radio-button--html-input"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioButton).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void uncheckedAndInvalidIsRenderedCorrectly() {
        var radioGroup = new RadioGroup<>("radioGroup", Model.of("not option1"));
        var radioButton = new RdRadioButton<>("radioButton", Model.of("option1"), radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radioButton'>"))
            .setMarkupId("radioButton");
        radioButton.error("some error");

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="radio"
                id="radioButton"
                name="radioGroup"
                value="radio0"
                aria-invalid="true"
                class="utrecht-radio-button utrecht-radio-button--html-input utrecht-radio-button--invalid"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioButton).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void checkedAndInvalidIsRenderedCorrectly() {
        var radioGroup = new RadioGroup<>("radioGroup", Model.of("option1"));
        var radioButton = new RdRadioButton<>("radioButton", Model.of("option1"), radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radioButton'>"))
            .setMarkupId("radioButton");
        radioButton.error("some error");

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="radio"
                id="radioButton"
                name="radioGroup"
                value="radio0"
                checked=""
                aria-invalid="true"
                class="utrecht-radio-button utrecht-radio-button--html-input utrecht-radio-button--invalid"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioButton).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledIsRenderedCorrectly() {
        var radioGroup = new RadioGroup<>("radioGroup", Model.of("not option1"));
        var radioButton = new RdRadioButton<>("radioButton", Model.of("option1"), radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radioButton'>"))
            .setMarkupId("radioButton")
            .setEnabled(false);

        // language=HTML
        String expectedHtmlFragment = """
            <input
                type="radio"
                id="radioButton"
                name="radioGroup"
                value="radio0"
                disabled=""
                class="utrecht-radio-button utrecht-radio-button--html-input utrecht-radio-button--disabled"
            />
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioButton).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
