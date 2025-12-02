package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldset;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/radio-group/">Radio Group</a>. It contains a {@link RadioGroup}, so can be used
 * where a <code>RadioGroup</code> is used. This must be attached to <code>&lt;div&gt;</code>. The content of the tag
 * must be the radio buttons of the group.
 * </p>
 * <p>
 * The Radio Group has the same options as the {@link RdFormFieldset}, but the validity of the fieldset is linked to the
 * validity of the contained <code>RadioGroup</code>.
 * </p>
 * <p>
 * Based on the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/story/react_react-form-field-radio-group--default">
 * React implementation of Utrecht</a>.
 * </p>
 * 
 * @param <T> the model object type for the <code>RadioGroup</code>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdRadioGroup<T> extends RdFormFieldset {
    private final IModel<T> model;
    private final Component descriptionComponent;
    private final Component errorMessageComponent;

    /**
     * <p>
     * Create an instance with the given Wicket ID, model for the {@link RadioGroup}, and label model. The Radio Group
     * will not have a description.
     * </p>
     * 
     * @param id the Wicket ID.
     * @param model the model for the <code>RadioGroup</code>.
     * @param labelModel the label model.
     */
    public RdRadioGroup(String id, IModel<T> model, IModel<?> labelModel) {
        this(id, model, labelModel, EMPTY_STRING_MODEL);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID, model for the {@link RadioGroup}, label model, and description
     * model.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model for the <code>RadioGroup</code>.
     * @param labelModel the label model.
     * @param descriptionModel the description model. If this model returns <code>null</code>, then the description will
     *                         not be displayed.
     */
    public RdRadioGroup(String id, IModel<T> model, IModel<?> labelModel, IModel<?> descriptionModel) {
        super(id, labelModel);
        this.model = model;
        add(RdRadioGroupBehavior.INSTANCE);

        descriptionComponent = newDescription("description", descriptionModel);
        errorMessageComponent = newError("error");
    }

    /**
     * <p>
     * Get the component attached to <code>&lt;div&gt;</code> containing the description.
     * </p>
     * 
     * @return the description component.
     */
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    /**
     * <p>
     * Get the component attached to <code>&lt;div&gt;</code> containing the error message.
     * </p>
     *
     * @return the error message component.
     */
    public Component getErrorMessageComponent() {
        return errorMessageComponent;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        getFieldsetComponentInternal().add(descriptionComponent, errorMessageComponent);
        customizeFieldset(getFieldsetComponent());
        getFieldsetComponent().add(new RdRadioGroupFieldsetBehavior(descriptionComponent, errorMessageComponent));
        
        getLegendComponent().add(RdRadioGroupLabelBehavior.INSTANCE);
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        
        setIsInvalid(getFieldsetComponent().hasErrorMessage());
    }

    @Override
    protected WebMarkupContainer newFieldset(String id) {
        var radioGroup = new RadioGroup<>(id, model);
        radioGroup.setRenderBodyOnly(false);
        return radioGroup;
    }

    private Component newDescription(String id, @Nullable IModel<?> model) {
        return new Label(id, model).add(
            RdFormFieldDescriptionBehavior.INSTANCE,
            RdRadioGroupDescriptionBehavior.INSTANCE);
    }

    private Component newError(String id) {
        return createErrorMessageLabel(id, getFieldsetComponent())
            .add(RdRadioGroupErrorMessageBehavior.INSTANCE);
    }
}
