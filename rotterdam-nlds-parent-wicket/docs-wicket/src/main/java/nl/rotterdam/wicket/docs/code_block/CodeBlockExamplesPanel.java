package nl.rotterdam.wicket.docs.code_block;

import nl.rotterdam.nl_design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class CodeBlockExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtCodeBlock.class;

    public CodeBlockExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtCodeBlock exampleCodeBlock() {
        return new UtrechtCodeBlock(
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
