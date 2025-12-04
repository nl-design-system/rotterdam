package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdDialogBehavior extends TagNameClassComponentBehavior<RdDialogBorder> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdDialogBehavior.class,
        "@amsterdam/design-system-css/dist/dialog/dialog.css"
    );

    static final RdDialogBehavior INSTANCE = new RdDialogBehavior();

    private RdDialogBehavior() {
        super("dialog", RdDialogCss.BASE);
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
