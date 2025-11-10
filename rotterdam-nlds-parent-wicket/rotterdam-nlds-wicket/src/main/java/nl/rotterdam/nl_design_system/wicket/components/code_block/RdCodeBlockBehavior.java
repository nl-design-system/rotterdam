package nl.rotterdam.nl_design_system.wicket.components.code_block;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdCodeBlockBehavior extends TagNameClassComponentBehavior<Component> {

    public RdCodeBlockBehavior() {
        super("pre", RdCodeBlockCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdCodeBlockBehavior.class, "@utrecht/code-block-css/dist/index.css"));
    }
}
