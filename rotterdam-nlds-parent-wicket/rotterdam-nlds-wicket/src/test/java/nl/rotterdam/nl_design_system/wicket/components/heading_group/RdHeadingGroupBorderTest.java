package nl.rotterdam.nl_design_system.wicket.components.heading_group;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.junit.jupiter.api.Test;

class RdHeadingGroupBorderTest extends NldsWicketTestCase {

    @Test
    void renders() {
        var headingGroup = new RdHeadingGroupBorder("headingGroup");
        headingGroup.setMarkup(Markup.of("<hgroup wicket:id='headingGroup'>Group contents</hgroup>"));

        // language=HTML
        String expectedHtmlFragment = """
            <hgroup class="utrecht-heading-group">Group contents</hgroup>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(headingGroup).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

}
