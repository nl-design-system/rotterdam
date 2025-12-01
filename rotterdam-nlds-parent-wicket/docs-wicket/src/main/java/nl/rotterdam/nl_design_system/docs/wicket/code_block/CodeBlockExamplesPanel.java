package nl.rotterdam.nl_design_system.docs.wicket.code_block;

import nl.rotterdam.nl_design_system.wicket.components.code_block.RdCodeBlock;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguage;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguageBehavior;
import org.apache.wicket.model.Model;

public class CodeBlockExamplesPanel extends ExamplesPanel {
    public CodeBlockExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdCodeBlock.class;
    }

    @ComponentExample
    private static RdCodeBlock exampleCodeBlock() {
        var codeBlock = new RdCodeBlock(
            "codeBlock",
            Model.of(
                """
                    <!DOCTYPE html>
                    <html lang="nl" dir="ltr">
                      <head>
                        <title>NL Design System</title>
                        <meta charset="utf-8"/>
                      </head>
                      <body>
                        <h1>NL Design System</h1>
                      </body>
                    </html>
                    """
            )
        );
        codeBlock.getCodeComponent().add(RdSyntaxHighlightingLanguageBehavior.of(Model.of(RdSyntaxHighlightingLanguage.MARKUP)));
        return codeBlock;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleCodeBlock());
    }
}
