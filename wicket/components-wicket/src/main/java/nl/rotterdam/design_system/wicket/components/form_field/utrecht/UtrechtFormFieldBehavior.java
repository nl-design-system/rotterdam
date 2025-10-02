package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.component_state.Community;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss.DEFAULT;

/**
 * Intentionally did not rename to NL, kept Utrecht in it. It has public visibility, can be used by library users,
 * and should only be used for Form Fields implemented by {@link Community} Utrecht.
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtFormFieldBehavior extends TagNameClassComponentBehavior<Component> {

    public static final UtrechtFormFieldBehavior INSTANCE = new UtrechtFormFieldBehavior();

    private UtrechtFormFieldBehavior() {
        super("div", DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }
}
