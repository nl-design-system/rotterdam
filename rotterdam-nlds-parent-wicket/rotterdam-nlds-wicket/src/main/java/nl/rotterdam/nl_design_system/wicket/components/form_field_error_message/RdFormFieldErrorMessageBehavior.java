package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

/**
 * <p>
 * Turn an element into a <a href="https://nldesignsystem.nl/form-field-error-message/">Form Field Error Message</a>.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field-error-message--docs">CSS
 * implementation of Utrecht</a>.
 * </p>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Singleton instance.
     */
    public static final RdFormFieldErrorMessageBehavior INSTANCE = new RdFormFieldErrorMessageBehavior();

    @Override
    public void bind(Component component) {
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private RdFormFieldErrorMessageBehavior() {
        super("div", RdFormFieldErrorMessageCss.BASE);
        addHeaderItem(
            cssReferenceHeaderItem(
                RdFormFieldErrorMessageBehavior.class,
                "@utrecht/form-field-error-message-css/dist/index.min.css"
            )
        );
    }
}
