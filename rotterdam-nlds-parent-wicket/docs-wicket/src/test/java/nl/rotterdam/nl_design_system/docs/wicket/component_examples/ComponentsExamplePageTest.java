package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link.LinkExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.junit.jupiter.api.Test;

import static nl.rotterdam.nl_design_system.docs.wicket.component_examples.ComponentsExamplePage.makeLabel;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ComponentsExamplePageTest extends NldsWicketTestCase {

    @Test
    void renders() {
        tester.startPage(ComponentsExamplePage.class);
        tester.assertRenderedPage(ComponentsExamplePage.class);
    }

    @Test
    void makeLabelOfExampleClassGeneratesNameAsExpected() {
        assertEquals("Link", makeLabel(LinkExamplesPanel.class));
        assertEquals("Action Group", makeLabel(ActionGroupExamplesPanel.class));
        assertEquals("Form Field Checkbox", makeLabel(FormFieldCheckboxExamplesPanel.class));
    }
}