package nl.rotterdam.nl_design_system.wicket.components.code_block.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtCodeBlockBehavior extends TagNameClassComponentBehavior<Component> {

    public UtrechtCodeBlockBehavior() {
        super("pre", RdCodeBlockCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(UtrechtCodeBlockBehavior.class, "@utrecht/code-block-css/dist/index.css"));
    }
}
