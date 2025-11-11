package nl.rotterdam.nl_design_system.wicket.components.body;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdBodyBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var body = new RdBodyBorder("body")
            .setMarkup(Markup.of("<body wicket:id='body'>Body</body>"));

        // language=HTML
        String expectedHtmlFragment = """
            <body class="utrecht-body">Body</body>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(body).toString();

        assertHtmlFragmentBodySame(expectedHtmlFragment, actualHtmlFragment);
    }

}
