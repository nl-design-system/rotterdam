package nl.rotterdam.wicket.docs.code_block;

import nl.rotterdam.design_system.wicket.components.code_block.utrecht.UtrechtCodeBlock;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class CodeBlockExamplesPanel extends Panel {

    public CodeBlockExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleCodeBlock() {
        return new UtrechtCodeBlock(
            "utrechtCodeBlock",
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
