package nl.rotterdam.nl_design_system.wicket.components.code_block;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

/**
 * Code block.
 * @deprecated  we don't have any apps needing this.
 */
@Deprecated(forRemoval = true)
public class RdCodeBlockBehavior extends TagNameClassComponentBehavior<Component> {


    /**
     * create default instance.
     */
    public RdCodeBlockBehavior() {
        super("pre", RdCodeBlockCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdCodeBlockBehavior.class, "@utrecht/code-block-css/dist/index.css"));
    }
}
