package nl.rotterdam.nl_design_system.docs.wicket.root;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.code_block.RdCodeBlock;
import nl.rotterdam.nl_design_system.wicket.components.root.RdRootBehavior;
import nl.rotterdam.nl_design_system.wicket.components.root.RdRootTransparentContainer;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguage;
import nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting.RdSyntaxHighlightingLanguageBehavior;
import org.apache.wicket.model.Model;

public class RootExamplesPanel extends ExamplesPanel {
    public RootExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdRootTransparentContainer.class;
    }

    @ComponentExample
    private static RdRootTransparentContainer exampleRoot() {
        return new RdRootTransparentContainer("root");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        var rootCode = new RdCodeBlock(
            "rootCode",
            Model.of("<html class=\"" +
                RdRootBehavior.INSTANCE.getClassNames() +
                "\">...</html>"))
            .add(RdSyntaxHighlightingLanguageBehavior.of(Model.of(RdSyntaxHighlightingLanguage.MARKUP)));
        add(rootCode);
    }
}
