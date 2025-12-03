package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

class RdRadioGroupTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var radioGroup = new RdRadioGroup<>("radioGroup", Model.of("some option"), Model.of("the label"))
            .setMarkup(Markup.of("<div wicket:id='radioGroup'></div>"))
            .setMarkupId("radioGroup");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='radioGroup' class='utrecht-form-fieldset utrecht-radio-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' role='radiogroup'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-radio-group__label'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void rendersDescriptionIfNotNull() {
        var radioGroup = new RdRadioGroup<>("radioGroup", Model.of("some option"), Model.of("the label"), Model.of("the description"))
            .setMarkup(Markup.of("<div wicket:id='radioGroup'></div>"))
            .setMarkupId("radioGroup");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='radioGroup' class='utrecht-form-fieldset utrecht-radio-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' role='radiogroup' aria-describedby='description1'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-radio-group__label'>the label</legend>
                    <div id="description1" class='utrecht-form-field-description utrecht-radio-group__description'>the description</div>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void sectionRendersCorrectly() {
        var radioGroup = new RdRadioGroup<>("radioGroup", Model.of("some option"), Model.of("the label"));
        radioGroup
            .setMarkup(Markup.of("<div wicket:id='radioGroup'></div>"))
            .setMarkupId("radioGroup");
        radioGroup.setIsSection(true);

        // language=HTML
        String expectedHtmlFragment = """
            <div id='radioGroup' class='utrecht-form-fieldset utrecht-form-fieldset--section utrecht-radio-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' role='radiogroup'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-radio-group__label'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRendersCorrectly() {
        var radioGroup = new RdRadioGroup<>("radioGroup", Model.of("some option"), Model.of("the label"));
        radioGroup
            .setMarkup(Markup.of("<div wicket:id='radioGroup'></div>"))
            .setMarkupId("radioGroup");
        radioGroup.getRadioGroup().error("the error");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='radioGroup' class='utrecht-form-fieldset utrecht-form-fieldset--invalid utrecht-radio-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' role='radiogroup' aria-invalid="true" aria-describedby="error2">
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-radio-group__label'>the label</legend>
                    <div id="error2" class="utrecht-form-field-error-message utrecht-radio-group__error-message">the error</div>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(radioGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
