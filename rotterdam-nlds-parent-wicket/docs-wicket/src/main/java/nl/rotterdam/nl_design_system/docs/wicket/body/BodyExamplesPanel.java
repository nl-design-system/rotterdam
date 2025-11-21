package nl.rotterdam.nl_design_system.docs.wicket.body;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.body.RdBodyTransparentContainer;
import nl.rotterdam.nl_design_system.wicket.components.code_block.RdCodeBlock;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguage;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguageBehavior;
import org.apache.wicket.model.Model;

public class BodyExamplesPanel extends ExamplesPanel {
    public BodyExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdBodyTransparentContainer.class;
    }

    @ComponentExample
    private static RdBodyTransparentContainer exampleBody() {
        return new RdBodyTransparentContainer("body");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        var bodyCode = new RdCodeBlock(
            "bodyCode",
            // TODO: it would be nice to get the class name from the code instead of copying it here.
            Model.of("<body class=\"utrecht-body\">Lorem ipsum dolor sit amet</body>"))
            .add(RdSyntaxHighlightingLanguageBehavior.of(Model.of(RdSyntaxHighlightingLanguage.MARKUP)));
        add(bodyCode);
    }
}
