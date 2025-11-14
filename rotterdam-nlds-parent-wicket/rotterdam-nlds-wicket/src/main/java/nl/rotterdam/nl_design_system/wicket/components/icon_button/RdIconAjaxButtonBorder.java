package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.visually_hidden.RdVisuallyHiddenBehavior;
import nl.rotterdam.nl_design_system.wicket.internal.components.button_border.AjaxButtonBorder;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.NonNull;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.AMSTERDAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.NOT_LISTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

/**
 * <p>
 * An Ajax button which is to be used for when a button only has an icon. The button does take a model for a label. This
 * label is present for accessibility. Use this component with a <code>&lt;button&gt;</code> element.
 * </p>
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = NOT_LISTED, htmlCssImplementedBy = AMSTERDAM)
public abstract class RdIconAjaxButtonBorder extends AjaxButtonBorder {
    @NonNull
    private final Component labelComponent;

    /**
     * <p>
     * Create a new instance with the given Wicket ID and the model for the accessibility label.
     * </p>
     * @param id the Wicket ID
     * @param model the model for the accessibility label.
     */
    public RdIconAjaxButtonBorder(final String id, final IModel<String> model) {
        super(id, requireNonNull(model));

        add(RdIconButtonBehavior.INSTANCE);

        labelComponent = newLabelComponent();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addToBorder(labelComponent);
    }

    /**
     * <p>
     * Get the accessibility label Wicket component for further customization: the component for the
     * <code>&lt;span&gt;</code> element.
     * </p>
     *
     * @return the accessibility label Wicket component.
     */
    public @NonNull Component getAccessibilityLabelComponent() {
        return labelComponent;
    }

    private Component newLabelComponent() {
        var label = new Label("label", getDefaultModel());
        label.add(RdVisuallyHiddenBehavior.INSTANCE);
        return label;
    }
}
