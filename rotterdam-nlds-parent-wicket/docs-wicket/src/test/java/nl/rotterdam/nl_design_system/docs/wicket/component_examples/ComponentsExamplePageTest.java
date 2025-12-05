package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link.LinkExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static nl.rotterdam.nl_design_system.docs.wicket.component_examples.ComponentsExamplePage.PAGE_PARAM_COMPONENT;
import static nl.rotterdam.nl_design_system.docs.wicket.component_examples.ComponentsExamplePage.makeLabel;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ComponentsExamplePageTest extends NldsWicketTestCase {

    @Test
    void rendersWithoutComponentParameter() {
        tester.startPage(ComponentsExamplePage.class);
        assertComponentExamplePageRendered();
    }

    @Test
    void makeLabelOfExampleClassGeneratesNameAsExpected() {
        assertEquals("Link", makeLabel(LinkExamplesPanel.class));
        assertEquals("Action Group", makeLabel(ActionGroupExamplesPanel.class));
        assertEquals("Form Field Checkbox", makeLabel(FormFieldCheckboxExamplesPanel.class));
    }

    @ParameterizedTest(name = "{index} => {0}")
    @FieldSource("nl.rotterdam.nl_design_system.docs.wicket.component_examples.ComponentExamplePanels#classes")
    void allExamplesRender(Class<?> exampleClass) {
        tester.startPage(ComponentsExamplePage.class, new PageParameters().set(PAGE_PARAM_COMPONENT, exampleClass.getSimpleName()));
        assertComponentExamplePageRendered();
    }

    private void assertComponentExamplePageRendered() {
        tester.assertRenderedPage(ComponentsExamplePage.class);
    }
}