package nl.rotterdam.nl_design_system.wicket.components.form_field_label;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.RADIO_BUTTON;

class RdFormFieldLabelBehaviorTest extends NldsWicketTestCase {
    @Test
    void baseRendersCorrectly() {
        var input = new TextField<>("input", Model.of(""));
        var behavior = new RdFormFieldLabelBehavior();
        behavior.setComponentLabelIsFor(input);
        var label = new WebMarkupContainer("label")
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'>The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='input1' class='utrecht-form-label'>The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledRendersCorrectly() {
        var input = new TextField<>("input", Model.of(""));
        input
            .setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior();
        behavior.setComponentLabelIsFor(input);
        var label = new WebMarkupContainer("label")
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'>The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='input1' class='utrecht-form-label utrecht-form-label--disabled'>The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void baseCheckboxRendersCorrectly() {
        var model = Model.<@Nullable Boolean>of();
        var checkbox = new CheckBox("checkbox", model);
        checkbox.setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'>"));
        var behavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        behavior.setComponentLabelIsFor(checkbox);
        var label = new WebMarkupContainer("label")
            .add(checkbox)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='checkbox'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='checkbox1' class='utrecht-form-label utrecht-form-label--checkbox'><input type='checkbox' name='label:checkbox' id='checkbox1'> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledCheckboxRendersCorrectly() {
        var model = Model.<@Nullable Boolean>of();
        var checkbox = new CheckBox("checkbox", model);
        checkbox
            .setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'>"))
            .setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        behavior.setComponentLabelIsFor(checkbox);
        var label = new WebMarkupContainer("label")
            .add(checkbox)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='checkbox'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='checkbox1' class='utrecht-form-label utrecht-form-label--checkbox utrecht-form-label--disabled'><input type='checkbox' name='label:checkbox' disabled id='checkbox1'> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void checkedCheckboxRendersCorrectly() {
        var model = Model.of(true);
        var checkbox = new CheckBox("checkbox", model);
        checkbox.setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'>"));
        var behavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        behavior.setComponentLabelIsFor(checkbox);
        var label = new WebMarkupContainer("label")
            .add(checkbox)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='checkbox'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='checkbox1' class='utrecht-form-label utrecht-form-label--checkbox utrecht-form-label--checked'><input type='checkbox' checked name='label:checkbox' id='checkbox1'> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledCheckedCheckboxRendersCorrectly() {
        var model = Model.of(true);
        var checkbox = new CheckBox("checkbox", model);
        checkbox
            .setMarkup(Markup.of("<input type='checkbox' wicket:id='checkbox'>"))
            .setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        behavior.setComponentLabelIsFor(checkbox);
        var label = new WebMarkupContainer("label")
            .add(checkbox)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='checkbox'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' for='checkbox1' class='utrecht-form-label utrecht-form-label--checkbox utrecht-form-label--disabled utrecht-form-label--checked'><input type='checkbox' checked name='label:checkbox' disabled id='checkbox1'> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void baseRadioButtonRendersCorrectly() {
        var groupModel = Model.<@Nullable String>of();
        var radioGroup = new RadioGroup<>("radioGroup", groupModel);
        var model = Model.of("option1");
        var radio = new Radio<>("radio", model, radioGroup);
        radio.setMarkup(Markup.of("<input type='radio' wicket:id='radio'>"));
        var behavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        var label = new WebMarkupContainer("label")
            .add(radio)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='radio'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' class='utrecht-form-label utrecht-form-label--radio'><input type='radio' id='radio1' name='radioGroup' value='radio0'> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledRadioButtonRendersCorrectly() {
        var groupModel = Model.<@Nullable String>of();
        var radioGroup = new RadioGroup<>("radioGroup", groupModel);
        var model = Model.of("option1");
        var radio = new Radio<>("radio", model, radioGroup)
            .setMarkup(Markup.of("<input type='radio' wicket:id='radio'>"))
            .setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        var label = new WebMarkupContainer("label")
            .add(radio)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='radio'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' class='utrecht-form-label utrecht-form-label--radio'><input type='radio' id='radio1' name='radioGroup' value='radio0' disabled> The label</label>
            """;
        
        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void checkedRadioButtonRendersCorrectly() {
        var groupModel = Model.of("option1");
        var radioGroup = new RadioGroup<>("radioGroup", groupModel);
        var model = Model.of("option1");
        var radio = new Radio<>("radio", model, radioGroup);
        radio.setMarkup(Markup.of("<input type='radio' wicket:id='radio'>"));
        var behavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        var label = new WebMarkupContainer("label")
            .add(radio)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='radio'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' class='utrecht-form-label utrecht-form-label--radio utrecht-form-label--checked'><input type='radio' id='radio1' name='radioGroup' value='radio0' checked> The label</label>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void disabledCheckedRadioButtonRendersCorrectly() {
        var groupModel = Model.of("option1");
        var radioGroup = new RadioGroup<>("radioGroup", groupModel);
        var model = Model.of("option1");
        var radio = new Radio<>("radio", model, radioGroup);
        radio
            .setMarkup(Markup.of("<input type='radio' wicket:id='radio'>"))
            .setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        var label = new WebMarkupContainer("label")
            .add(radio)
            .add(behavior)
            .setMarkup(Markup.of("<label wicket:id='label'><input wicket:id='radio'> The label</label>"))
            .setMarkupId("label");

        // language=HTML
        String expectedHtmlFragment = """
            <label id='label' class='utrecht-form-label utrecht-form-label--radio utrecht-form-label--checked'><input type='radio' id='radio1' name='radioGroup' value='radio0' checked disabled> The label</label>
            """;

        String actualHtmlFragment = ComponentRenderer.renderComponent(label).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
