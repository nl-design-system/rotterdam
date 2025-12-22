package nl.rotterdam.nl_design_system.wicket.components.form_field_description;

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
 * Turn an element into a <a href="https://nldesignsystem.nl/form-field-description/">Form Field Description</a>.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field-description--docs">CSS
 * implementation of Utrecht</a>.
 * </p>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldDescriptionBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Singleton instance.
     */
    public static final RdFormFieldDescriptionBehavior INSTANCE = new RdFormFieldDescriptionBehavior();

    @Override
    public void bind(Component component) {
        component.setOutputMarkupId(true);
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private RdFormFieldDescriptionBehavior() {
        super("div", RdFormFieldDescriptionCss.BASE);
        addHeaderItem(
            cssReferenceHeaderItem(
                RdFormFieldDescriptionBehavior.class,
                "@utrecht/form-field-description-css/dist/index.min.css"
            )
        );
    }
}
