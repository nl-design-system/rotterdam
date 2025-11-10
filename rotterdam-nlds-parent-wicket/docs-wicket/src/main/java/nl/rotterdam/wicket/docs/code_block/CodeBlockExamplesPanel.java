package nl.rotterdam.wicket.docs.code_block;

import nl.rotterdam.nl_design_system.wicket.components.code_block.RdCodeBlock;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
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
        return new RdCodeBlock(
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
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleCodeBlock());
    }
}
