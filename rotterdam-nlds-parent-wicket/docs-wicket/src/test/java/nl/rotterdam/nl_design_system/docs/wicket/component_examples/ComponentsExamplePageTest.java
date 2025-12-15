package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link.LinkExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import nl.rotterdam.nl_design_system.wicket.test_common.WicketAssertions;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.IReferenceHeaderItem;
import org.apache.wicket.markup.head.filter.FilteringHeaderResponse;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.markup.html.IHeaderResponseDecorator;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.ArrayList;
import java.util.List;

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
    void allExamplesRenderWithAllResourcesFound(Class<?> exampleClass) {

        CapturingHeaderResponseDecorator decorator = new CapturingHeaderResponseDecorator();

        tester.getApplication().getHeaderResponseDecorators().add(decorator);

        tester.startPage(ComponentsExamplePage.class, new PageParameters().set(PAGE_PARAM_COMPONENT, exampleClass.getSimpleName()));
        assertComponentExamplePageRendered();


        decorator
            .getCapturedItems()
            .stream()
            .filter(item -> (item instanceof IReferenceHeaderItem))
            .map(item -> (IReferenceHeaderItem) item)
            .forEach(WicketAssertions::assertHeaderItemExists);
    }

    private void assertComponentExamplePageRendered() {
        tester.assertRenderedPage(ComponentsExamplePage.class);
    }
}

class CapturingHeaderResponseDecorator implements IHeaderResponseDecorator {

    private final List<HeaderItem> capturedItems = new ArrayList<>();

    @Override
    public IHeaderResponse decorate(IHeaderResponse response) {
        // Wrap the response so we can intercept render()
        return new FilteringHeaderResponse(new JavaScriptFilteredIntoFooterHeaderResponse(response, "footer")) {
            @Override
            public void render(HeaderItem item) {
                capturedItems.add(item);
                super.render(item);
            }
        };
    }

    public List<HeaderItem> getCapturedItems() {
        return capturedItems;
    }
}
