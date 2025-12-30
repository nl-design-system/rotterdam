package nl.rotterdam.nl_design_system.wicket.components.code;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdCodeBorderTest extends NldsWicketTestCase {

    @Test
    void baseRendersCorrectly() {
        var code = new RdCodeBorder("code")
            .setMarkup(Markup.of("<code wicket:id='code'>&lt;p&gt;the lazy fox jumps over the quick brown dog&lt;/p&gt;</code>"))
            .setMarkupId("code");

        // language=HTML
        String expectedHtmlFragment = """
            <code id='code' class='nl-code' translate='no'>&lt;p&gt;the lazy fox jumps over the quick brown dog&lt;/p&gt;</code>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(code).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
