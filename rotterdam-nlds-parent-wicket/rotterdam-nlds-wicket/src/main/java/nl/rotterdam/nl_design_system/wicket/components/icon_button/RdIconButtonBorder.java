package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.visually_hidden.RdVisuallyHiddenBehavior;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import nl.rotterdam.nl_design_system.wicket.internal.components.button_border.ButtonBorder;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.AMSTERDAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.NOT_LISTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

/**
 * <p>
 * A button which is to be used for when a button only has an icon. The button does take a model for a label. This label
 * is present for accessibility. Use this component with a <code>&lt;button&gt;</code> element.
 * </p>
 * <p>
 * If used inside a heading, the correct heading level can be set using
 * {@link #setHeadingLevel(RdIconButtonSize)}.
 * </p>
 *
 * @see RdIconButtonSize
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = NOT_LISTED, htmlCssImplementedBy = AMSTERDAM)
public abstract class RdIconButtonBorder extends ButtonBorder {
    @NonNull
    private final Component labelComponent;

    @NonNull
    private final Component iconComponent;

    @Nullable
    private RdIconButtonSize headingLevel;

    /**
     * <p>
     * Create a new instance with the given Wicket ID and the model for the accessibility label.
     * </p>
     * @param id the Wicket ID.
     * @param model the model for the accessibility label.
     */
    public RdIconButtonBorder(final String id, final IModel<String> model) {
        super(id, model);
        requireNonNull(model);

        add(RdIconButtonBehavior.INSTANCE);

        labelComponent = newLabelComponent();
        iconComponent = newIconComponent();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addToBorder(labelComponent, iconComponent);
    }

    /**
     * <p>
     * Set the heading level to the given value.
     * </p>
     *
     * @param headingLevel the (optional) heading level.
     * @see RdIconButtonSize
     */
    public void setHeadingLevel(@Nullable RdIconButtonSize headingLevel) {
        this.headingLevel = headingLevel;
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

    /**
     * <p>
     * Get the icon Wicket component for further customization: the component for the <code>&lt;span&gt;</code> element
     * wrapping the icon body.
     * </p>
     *
     * @return the icon Wicket component.
     */
    public @NonNull Component getIconComponent() {
        return iconComponent;
    }

    private Component newLabelComponent() {
        var label = new Label("label", RdIconButtonBorder.this.getDefaultModel());
        label.add(RdVisuallyHiddenBehavior.INSTANCE);
        return label;
    }

    private Component newIconComponent() {
        return new WebMarkupContainer("icon") {

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                new TokenSetBuilder()
                    .append(headingLevel != null, () -> headingLevel.getClassNames())
                    .use((classNames) -> tag.append("class", classNames, " "));
            }
        };
    }
}
