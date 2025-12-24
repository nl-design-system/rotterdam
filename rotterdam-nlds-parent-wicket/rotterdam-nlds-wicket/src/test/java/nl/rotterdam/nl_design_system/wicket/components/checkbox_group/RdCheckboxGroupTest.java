package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

class RdCheckboxGroupTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var checkboxGroup = new RdCheckboxGroup<>("checkboxGroup", createNoSelectionModel(), Model.of("the label"))
            .setMarkup(Markup.of("<div wicket:id='checkboxGroup'></div>"))
            .setMarkupId("checkboxGroup");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='checkboxGroup' class='utrecht-form-fieldset utrecht-checkbox-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-checkbox-group__label'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkboxGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void rendersDescriptionIfNotNull() {
        var checkboxGroup = new RdCheckboxGroup<>("checkboxGroup", createNoSelectionModel(), Model.of("the label"), Model.of("the description"))
            .setMarkup(Markup.of("<div wicket:id='checkboxGroup'></div>"))
            .setMarkupId("checkboxGroup");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='checkboxGroup' class='utrecht-form-fieldset utrecht-checkbox-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' aria-describedby='description1'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-checkbox-group__label'>the label</legend>
                    <div id="description1" class='utrecht-form-field-description utrecht-checkbox-group__description'>the description</div>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkboxGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void sectionRendersCorrectly() {
        var checkboxGroup = new RdCheckboxGroup<>("checkboxGroup", createNoSelectionModel(), Model.of("the label"));
        checkboxGroup
            .setMarkup(Markup.of("<div wicket:id='checkboxGroup'></div>"))
            .setMarkupId("checkboxGroup");
        checkboxGroup.setIsSection(true);

        // language=HTML
        String expectedHtmlFragment = """
            <div id='checkboxGroup' class='utrecht-form-fieldset utrecht-form-fieldset--section utrecht-checkbox-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-checkbox-group__label'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkboxGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRendersCorrectly() {
        var checkboxGroup = new RdCheckboxGroup<>("checkboxGroup", createNoSelectionModel(), Model.of("the label"));
        checkboxGroup
            .setMarkup(Markup.of("<div wicket:id='checkboxGroup'></div>"))
            .setMarkupId("checkboxGroup");
        checkboxGroup.getCheckGroup().error("the error");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='checkboxGroup' class='utrecht-form-fieldset utrecht-form-fieldset--invalid utrecht-checkbox-group'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset' aria-invalid="true" aria-describedby="error2">
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend utrecht-checkbox-group__label'>the label</legend>
                    <div id="error2" class="utrecht-form-field-error-message utrecht-checkbox-group__error-message">the error</div>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(checkboxGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    private static @NonNull IModel<Collection<String>> createNoSelectionModel() {
        return Model.of((Collection<String>) new ArrayList<String>());
    }
}
