package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

class RdFieldsetTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var fieldset = new RdFieldset<>("fieldset", Model.of((String)null), Model.of("the label"))
            .setMarkup(Markup.of("<div wicket:id='fieldset'></div>"))
            .setMarkupId("fieldset");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='fieldset' class='utrecht-form-fieldset'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(fieldset).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void legendIsNoRenderedIfLabelNull() {
        var fieldset = new RdFieldset<>("fieldset", Model.of((String)null), Model.of((String) null))
            .setMarkup(Markup.of("<div wicket:id='fieldset'></div>"))
            .setMarkupId("fieldset");

        // language=HTML
        String expectedHtmlFragment = """
            <div id='fieldset' class='utrecht-form-fieldset'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(fieldset).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void sectionRendersCorrectly() {
        var fieldset = new RdFieldset<>("fieldset", Model.of((String)null), Model.of("the label"));
        fieldset
            .setMarkup(Markup.of("<div wicket:id='fieldset'></div>"))
            .setMarkupId("fieldset");
        fieldset.setIsSection(true);

        // language=HTML
        String expectedHtmlFragment = """
            <div id='fieldset' class='utrecht-form-fieldset utrecht-form-fieldset--section'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(fieldset).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRendersCorrectly() {
        var fieldset = new RdFieldset<>("fieldset", Model.of((String)null), Model.of("the label"));
        fieldset
            .setMarkup(Markup.of("<div wicket:id='fieldset'></div>"))
            .setMarkupId("fieldset");
        fieldset.setIsInvalid(true);

        // language=HTML
        String expectedHtmlFragment = """
            <div id='fieldset' class='utrecht-form-fieldset utrecht-form-fieldset--invalid'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(fieldset).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidSectionRendersCorrectly() {
        var fieldset = new RdFieldset<>("fieldset", Model.of((String)null), Model.of("the label"));
        fieldset
            .setMarkup(Markup.of("<div wicket:id='fieldset'></div>"))
            .setMarkupId("fieldset");
        fieldset.setIsSection(true);
        fieldset.setIsInvalid(true);

        // language=HTML
        String expectedHtmlFragment = """
            <div id='fieldset' class='utrecht-form-fieldset utrecht-form-fieldset--invalid utrecht-form-fieldset--section'>
                <fieldset class='utrecht-form-fieldset__fieldset utrecht-form-fieldset--html-fieldset'>
                    <legend class='utrecht-form-fieldset__legend utrecht-form-fieldset__legend--html-legend'>the label</legend>
                </fieldset>
            </div>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(fieldset).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
