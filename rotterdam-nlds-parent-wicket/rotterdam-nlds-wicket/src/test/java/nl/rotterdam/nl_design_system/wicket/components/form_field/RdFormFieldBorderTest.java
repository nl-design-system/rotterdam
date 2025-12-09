package nl.rotterdam.nl_design_system.wicket.components.form_field;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;

class RdFormFieldBorderTest extends NldsWicketTestCase {
    @Test
    void baseRendersCorrectly() {
        var formField = new RdFormFieldBorder<>("formField", Model.of(""), Model.of("The label")) {
            @Override
            protected @NonNull FormComponent<String> newInput(@NonNull IModel<String> model) {
                var input = new TextField<>("input", model);
                input
                    .setMarkup(Markup.of("<input type='text' wicket:id='input'>"));
                return input;
            }
        }
            .setMarkup(Markup.of("<div wicket:id='formField'><input wicket:id='input'></div>"))
            .setMarkupId("formField");

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-form-field" id="formField">
                <div class="utrecht-form-field__label">
                    <label class="utrecht-form-label" for="input1">The label</label>
                </div>
                <div class="utrecht-form-field__input">
                    <input id="input1" name="formField:input-container:formField_body:input" type="text" value="">
                </div>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(formField).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRendersCorrectly() {
        var formField = new RdFormFieldBorder<>("formField", Model.of(""), Model.of("The label")) {
            @Override
            protected @NonNull FormComponent<String> newInput(@NonNull IModel<String> model) {
                var input = new TextField<>("input", model);
                input
                    .setMarkup(Markup.of("<input type='text' wicket:id='input'>"))
                    .error("The error");
                return input;
            }
        }
            .setMarkup(Markup.of("<div wicket:id='formField'><input wicket:id='input'></div>"))
            .setMarkupId("formField");

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-form-field utrecht-form-field--invalid" id="formField">
                <div class="utrecht-form-field__label">
                    <label class="utrecht-form-label" for="input1">The label</label>
                </div>
                <div class="utrecht-form-field-error-message utrecht-form-field__error-message" id="error2">The error</div>
                <div class="utrecht-form-field__input">
                    <input id="input1" name="formField:input-container:formField_body:input" type="text" value="">
                </div>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(formField).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
