package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Locale;

class RdIconButtonBorderTest extends NldsWicketTestCase {

    @Test
    void renderWithoutSize() {
        var button = new RdIconButtonBorder("button", Model.of("Label")) {
        }
            .setMarkup(Markup.of("<button wicket:id='button'>Icon</button>"));

        // language=HTML
        String expectedHtmlFragment = """
            <button name="button" id="button1" class="ams-icon-button"><span class="ams-visually-hidden">Label</span><span class="ams-icon ams-icon--square">Icon</span></button>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(button).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @ParameterizedTest
    @EnumSource(RdIconButtonSize.class)
    void renderWithSize(RdIconButtonSize size) {
        var button = new RdIconButtonBorder("button", Model.of("Label")) {
        };
        button.setHeadingLevel(size);
        button.setMarkup(Markup.of("<button wicket:id='button'>Icon</button>"));

        var levelCassClassNameSuffix = size.name().toLowerCase(Locale.ROOT).replace('_', '-');
        // language=HTML
        String expectedHtmlFragment = """
            <button name="button" id="button1" class="ams-icon-button"><span class="ams-visually-hidden">Label</span><span class="ams-icon ams-icon--square ams-icon--%s">Icon</span></button>"""
            .formatted(levelCassClassNameSuffix);

        String actualHtmlFragment = ComponentRenderer.renderComponent(button).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
