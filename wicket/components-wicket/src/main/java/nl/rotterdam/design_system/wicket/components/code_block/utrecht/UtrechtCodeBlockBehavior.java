package nl.rotterdam.design_system.wicket.components.code_block.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtCodeBlockBehavior extends TagNameClassComponentBehavior {

    public UtrechtCodeBlockBehavior() {
        super("pre", "utrecht-code-block");
        addHeaderItem(cssReferenceHeaderItem(UtrechtCodeBlockBehavior.class, "@utrecht/code-block-css/dist/index.css"));
    }
}
