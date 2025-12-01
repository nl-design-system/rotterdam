package nl.rotterdam.nl_design_system.wicket.components.column_layout;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdColumnLayoutBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var columnLayout = new RdColumnLayoutBorder("columnLayout");
        columnLayout.setMarkup(Markup.of("<div wicket:id='columnLayout'>Column contents</div>"));

        // language=HTML
        String expectedHtmlFragment = """
            <div class="utrecht-column-layout">Column contents</div>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(columnLayout).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}