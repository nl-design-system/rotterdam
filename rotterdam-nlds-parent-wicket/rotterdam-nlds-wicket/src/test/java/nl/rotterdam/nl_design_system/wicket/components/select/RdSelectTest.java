package nl.rotterdam.nl_design_system.wicket.components.select;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;

import java.util.List;

class RdSelectTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var select = new RdSelect<>("select", Model.of(), List.of("option1", "option2"))
            .setMarkup(Markup.of("<select wicket:id='select'></select>"))
            .setMarkupId("select");

        // language=HTML
        String expectedHtmlFragment = """
            <select name='select' id='select' class='utrecht-select utrecht-select--html-select'>
                <option selected value="">Choose One</option>
                <option value="0">option1</option>
                <option value="1">option2</option>
            </select>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(select).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void requiredRendersCorrectly() {
        var select = new RdSelect<>("select", Model.of(), List.of("option1", "option2"));
        select
            .setMarkup(Markup.of("<select wicket:id='select'></select>"))
            .setMarkupId("select");
        select.setRequired(true);

        // language=HTML
        String expectedHtmlFragment = """
            <select name='select' id='select' class='utrecht-select utrecht-select--html-select utrecht-select--required'>
                <option selected value="">Choose One</option>
                <option value="0">option1</option>
                <option value="1">option2</option>
            </select>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(select).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void selectedOptionRendersCorrectly() {
        var select = new RdSelect<>("select", Model.of("option1"), List.of("option1", "option2"))
            .setMarkup(Markup.of("<select wicket:id='select'></select>"))
            .setMarkupId("select");

        // language=HTML
        String expectedHtmlFragment = """
            <select name='select' id='select' class='utrecht-select utrecht-select--html-select'>
                <option value="0" selected=''>option1</option>
                <option value="1">option2</option>
            </select>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(select).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void invalidRendersCorrectly() {
        var select = new RdSelect<>("select", Model.of(), List.of("option1", "option2"));
        select
            .setMarkup(Markup.of("<select wicket:id='select'></select>"))
            .setMarkupId("select");
        select.error("some error");

        // language=HTML
        String expectedHtmlFragment = """
            <select name='select' id='select' aria-invalid='true' class='utrecht-select utrecht-select--html-select utrecht-select--invalid'>
                <option selected value="">Choose One</option>
                <option value="0">option1</option>
                <option value="1">option2</option>
            </select>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(select).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledRendersCorrectly() {
        var select = new RdSelect<>("select", Model.of(), List.of("option1", "option2"));
        select
            .setMarkup(Markup.of("<select wicket:id='select'></select>"))
            .setMarkupId("select");
        select.setEnabled(false);

        // language=HTML
        String expectedHtmlFragment = """
            <select name='select' id='select' disabled='' class='utrecht-select utrecht-select--html-select'>
                <option selected value="">Choose One</option>
                <option value="0">option1</option>
                <option value="1">option2</option>
            </select>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(select).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
