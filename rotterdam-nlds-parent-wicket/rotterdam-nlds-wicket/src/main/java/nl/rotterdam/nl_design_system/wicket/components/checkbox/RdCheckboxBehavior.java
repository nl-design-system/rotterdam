package nl.rotterdam.nl_design_system.wicket.components.checkbox;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.LabeledWebMarkupContainer;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxCss.BASE;
import static nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxCss.DISABLED;
import static nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

/**
 * Applies NL Design System checkbox styles to a Wicket CheckBox component.
 *
 * <p>Some characteristics are not taken into account, so to be fully compliant use {@link RdCheckbox}.</p>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdCheckboxBehavior extends TagNameClassComponentBehavior<LabeledWebMarkupContainer> {

    /**
     * Singleton instance.
     */
    public static final RdCheckboxBehavior INSTANCE = new RdCheckboxBehavior();

    private RdCheckboxBehavior() {
        super("input", BASE);
        addHeaderItem(cssReferenceHeaderItem(RdCheckboxBehavior.class, "@utrecht/checkbox-css/dist/index.min.css"));
        addHeaderItem(cssReferenceHeaderItem(RdCheckboxBehavior.class, "@utrecht/custom-checkbox-css/dist/index.min.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(LabeledWebMarkupContainer component, ComponentTag tag) {
        List<CssClassNames> classNames = new ArrayList<>();

        if (!component.isEnabledInHierarchy()) {
            classNames.add(DISABLED);
        }

        if (component instanceof FormComponent<?> formComponent && formComponent.isRequired()) {
            tag.put("aria-required", "true");
        }

        if (component.hasErrorMessage()) {
            classNames.add(INVALID);
            tag.put("aria-invalid", "true");
        }

        return classNames;
    }
}
