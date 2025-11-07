package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.Button;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdIconButtonBehavior extends TagNameClassComponentBehavior<Button> {
    
    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdIconButtonBehavior.class,
        "@amsterdam/design-system-css/dist/icon-button/icon-button.css"
    );

    static final RdIconButtonBehavior INSTANCE = new RdIconButtonBehavior();

    private RdIconButtonBehavior() {
        super("button", RdIconButtonCss.DEFAULT);
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
