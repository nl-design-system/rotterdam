package nl.rotterdam.nl_design_system.wicket.components.code_block;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Code block.
 */
public class RdCodeBlockBehavior extends TagNameClassComponentBehavior<Component> {


    /**
     * create default instance.
     */
    public RdCodeBlockBehavior() {
        super("pre", RdCodeBlockCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdCodeBlockBehavior.class, "@nl-design-system-candidate/code-block-css/dist/code-block.css"));
    }
}
