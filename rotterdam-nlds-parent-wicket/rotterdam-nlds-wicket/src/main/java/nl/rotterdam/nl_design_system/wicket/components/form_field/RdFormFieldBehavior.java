package nl.rotterdam.nl_design_system.wicket.components.form_field;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.DEFAULT;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.Community;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

/**
 * It has public visibility, can be used by library users, and should only be used for Form Fields implemented by
 * {@link Community} Utrecht.
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldBehavior extends TagNameClassComponentBehavior<Component> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdFormFieldBehavior.class,
        "@utrecht/form-field-css/dist/index.min.css"
    );

    /**
     * Singleton instance.
     */
    public static final RdFormFieldBehavior INSTANCE = new RdFormFieldBehavior();

    private RdFormFieldBehavior() {
        super("div", DEFAULT);
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
