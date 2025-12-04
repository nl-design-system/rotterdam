package nl.rotterdam.nl_design_system.docs.wicket.form_field_label;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckbox;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.Objects;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.RADIO_BUTTON;

public class FormFieldLabelExamplesPanel extends ExamplesPanel {
    public FormFieldLabelExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldLabelBehavior.class;
    }

    @ComponentExample
    private static WebMarkupContainer exampleFormFieldStaticLabel() {
        var component = new WebMarkupContainer("formFieldStaticLabel");
        component.add(new RdFormFieldLabelBehavior());
        return component;
    }

    @ComponentExample
    private static WebMarkupContainer exampleFormFieldDynamicLabel() {
        var component = new WebMarkupContainer("formFieldDynamicLabel");
        component.add(new RdFormFieldLabelBehavior());
        component.add(new Label("label", Model.of(LocalDate.now().toString())));
        return component;
    }

    @ComponentExample
    private static WebMarkupContainer exampleDisabledFormFieldLabel() {
        var component = new WebMarkupContainer("disabledFormFieldLabel");
        var input = new TextField<>("someId", Model.of(""));
        input.setEnabled(false);
        var behavior = new RdFormFieldLabelBehavior();
        behavior.setComponentLabelIsFor(input);
        component.add(behavior);
        return component;
    }

    @ComponentExample
    private static WebMarkupContainer exampleFormFieldLabelCheckbox() {
        var component = new WebMarkupContainer("formFieldLabelCheckbox");
        var model = Model.of(false);
        var labelBehavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        component.add(labelBehavior);

        var checkbox = new RdCheckbox("checkbox", model);
        labelBehavior.setComponentLabelIsFor(checkbox);
        component.add(checkbox);
        
        return component;
    }

    @ComponentExample
    private static WebMarkupContainer exampleFormFieldLabelCheckboxChecked() {
        var component = new WebMarkupContainer("formFieldLabelCheckboxChecked");
        var model = Model.of(true);
        var labelBehavior = new RdFormFieldLabelBehavior(CHECKBOX, model);
        component.add(labelBehavior);
        
        var checkbox = new RdCheckbox("checkbox", model);
        labelBehavior.setComponentLabelIsFor(checkbox);
        component.add(checkbox);
        
        return component;
    }

    @ComponentExample
    private static RadioGroup<?> exampleFormFieldLabelRadioButton() {
        var groupModel = Model.<@Nullable String>of();
        var model = Model.of("option1");

        var radioGroup = new RadioGroup<>("formFieldLabelRadioButton", groupModel);

        var component = new WebMarkupContainer("label");
        var labelBehavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        component.add(labelBehavior);

        var radio = new Radio<>("radio", model);
        labelBehavior.setComponentLabelIsFor(radio);

        radioGroup.add(
            component.add(
                radio
            )
        );

        return radioGroup;
    }

    @ComponentExample
    private static RadioGroup<?> exampleFormFieldLabelRadioButtonChecked() {
        var groupModel = Model.of("option1");
        var model = Model.of("option1");

        var radioGroup = new RadioGroup<>("formFieldLabelRadioButtonChecked", Model.of("option1"));

        var component = new WebMarkupContainer("label");
        var labelBehavior = new RdFormFieldLabelBehavior(RADIO_BUTTON, model.combineWith(groupModel, Objects::equals));
        component.add(labelBehavior);

        var radio = new Radio<>("radio", model);
        labelBehavior.setComponentLabelIsFor(radio);

        radioGroup.add(
            component.add(
                radio
            )
        );

        return radioGroup;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldStaticLabel(),
            exampleFormFieldDynamicLabel(),
            exampleDisabledFormFieldLabel(),
            exampleFormFieldLabelCheckbox(),
            exampleFormFieldLabelCheckboxChecked(),
            exampleFormFieldLabelRadioButton(),
            exampleFormFieldLabelRadioButtonChecked());
    }
}
