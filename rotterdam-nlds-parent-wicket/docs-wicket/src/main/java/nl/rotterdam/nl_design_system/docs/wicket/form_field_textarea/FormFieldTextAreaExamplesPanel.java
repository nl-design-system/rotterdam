package nl.rotterdam.nl_design_system.docs.wicket.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.form_field_textarea.RdFormFieldTextArea;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;
import org.jspecify.annotations.Nullable;

public class FormFieldTextAreaExamplesPanel extends ExamplesPanel {
    public FormFieldTextAreaExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldTextArea.class;
    }

    @ComponentExample
    private static RdFormFieldTextArea<String> exampleFormFieldTextArea() {
        return new RdFormFieldTextArea<>(
            "formFieldTextArea",
            Model.of("Dit is een voorbeeldtekst in het tekstveld."),
            Model.of("Opmerking"),
            Model.of("Voer hier eventuele opmerkingen in.")
        );
    }

    @ComponentExample
    private static RdFormFieldTextArea<@Nullable String> exampleFormFieldTextAreaRequired() {
        return new RdFormFieldTextArea<>(
            "formFieldTextAreaRequired",
            DefaultModels.NULL_STRING_MODEL,
            Model.of("Beschrijving")
        )
            .setRequired(true);
    }

    @ComponentExample
    private static RdFormFieldTextArea<String> exampleFormFieldTextAreaDisabled() {
        RdFormFieldTextArea<String> component = new RdFormFieldTextArea<>(
            "formFieldTextAreaDisabled",
            Model.of("Dit tekstveld kan niet worden bewerkt."),
            Model.of("Opmerking"),
            Model.of("Dit veld is uitgeschakeld.")
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFormFieldTextArea<String> exampleFormFieldTextAreaWithRowsConfigured() {
        return new RdFormFieldTextArea<>(
            "formFieldTextAreaWithRowsConfigured",
            Model.of(""),
            Model.of("Lange opmerking"),
            Model.of("U kunt meerdere regels tekst invoeren.")
        ).withTextArea((textArea, formField) ->
            textArea.add(
                AttributeModifier.replace("rows", "6"),
                AttributeModifier.replace("cols", "50")
            )
        );
    }

    @ComponentExample
    private static RdFormFieldTextArea<String> exampleFormFieldTextAreaWithMaxLength() {
        RdFormFieldTextArea<String> component = new RdFormFieldTextArea<>(
            "formFieldTextAreaWithMaxLength",
            Model.of("Een tekst die toch wat langer is dan achtentwintig tekens"),
            Model.of("Opmerking met maximale lengte"),
            Model.of("Maximaal 28 tekens toegestaan.")
        ).withTextArea((textArea, formField) -> {
                textArea.add(StringValidator.maximumLength(28));
                textArea.error("De tekst is te lang. Er zijn maximaal 28 tekens toegestaan.");
            }
        ).setRequired(true);
        
        component.getTextArea().error("De ingevoerde tekst is langer dan toegestaan");
        
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldTextArea(),
            exampleFormFieldTextAreaRequired(),
            exampleFormFieldTextAreaDisabled(),
            exampleFormFieldTextAreaWithRowsConfigured(),
            exampleFormFieldTextAreaWithMaxLength()
        );
    }
}
