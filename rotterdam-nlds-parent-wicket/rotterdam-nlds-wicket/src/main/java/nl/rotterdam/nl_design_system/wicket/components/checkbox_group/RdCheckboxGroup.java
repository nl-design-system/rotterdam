package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldset;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.CollectionModel;
import org.jspecify.annotations.Nullable;

import java.util.Collection;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.NULL_STRING_MODEL;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/checkbox-group/">Checkbox Group</a>. It contains a {@link CheckGroup}, so can be
 * used where a <code>CheckGroup</code> is used. Do not add a
 * {@link org.apache.wicket.markup.html.form.CheckGroupSelector CheckGroupSelector} as a Checkbox Group only contains
 * checkboxes for values and not for components controlling those values. A <code>CheckGroupSelector</code> can be used
 * separately, passing an instance of this class to its constructor. This must be attached to <code>&lt;div&gt;</code>.
 * </p>
 * <p>
 * The Checkbox Group has the same options as the {@link RdFieldset}, but the validity of the fieldset is linked to the
 * validity of the contained <code>CheckGroup</code>.
 * </p>
 * <p>
 * Based on the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/react_react-form-field-checkbox-group--docs">
 * React implementation of Utrecht</a>.
 * </p>
 *
 * @param <T> the model object type of the <code>CheckGroup</code>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdCheckboxGroup<T extends @Nullable Object> extends RdFieldset {

    private final IModel<? extends Collection<T>> model;
    private final Component descriptionComponent;
    private final Component errorMessageComponent;

    /**
     * <p>
     * Create an instance with the given Wicket ID, list of values for the {@link CheckGroup}, and label model. The
     * Checkbox Group will not have a description.
     * </p>
     *
     * @param id the Wicket ID.
     * @param collection the values for the <code>CheckGroup</code>.
     * @param labelModel the label model.
     */
    public RdCheckboxGroup(String id, Collection<T> collection, IModel<?> labelModel) {
        this(id, new CollectionModel<>(collection), labelModel, NULL_STRING_MODEL);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID, model with list of values for the {@link CheckGroup}, and label
     * model. The Checkbox Group will not have a description.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model for the <code>CheckGroup</code>.
     * @param labelModel the label model.
     */
    public RdCheckboxGroup(String id, IModel<? extends Collection<T>> model, IModel<?> labelModel) {
        this(id, model, labelModel, NULL_STRING_MODEL);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID, list of values for the {@link CheckGroup}, label model, and
     * descriptiion model.
     * </p>
     *
     * @param id the Wicket ID.
     * @param collection the values for the <code>CheckGroup</code>.
     * @param labelModel the label model.
     * @param descriptionModel the description model. If this model returns <code>null</code>, then the description will
     *                         not be displayed.
     */
    public RdCheckboxGroup(String id, Collection<T> collection, IModel<?> labelModel, IModel<?> descriptionModel) {
        this(id, new CollectionModel<>(collection), labelModel, descriptionModel);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID, model with list of values for the {@link CheckGroup}, label model,
     * and description model.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model for the <code>CheckGroup</code>.
     * @param labelModel the label model.
     * @param descriptionModel the description model. If this model returns <code>null</code>, then the description will
     *                         not be displayed.
     */
    public RdCheckboxGroup(String id, IModel<? extends Collection<T>> model, IModel<?> labelModel, IModel<?> descriptionModel) {
        super(id, labelModel);
        this.model = model;
        add(RdCheckboxGroupBehavior.INSTANCE);

        descriptionComponent = newDescription("description", descriptionModel);
        errorMessageComponent = newError("error");
    }

    /**
     * <p>
     * Get the actual check group.
     * </p>
     *
     * @return the actual check group.
     */
    public CheckGroup<T> getCheckGroup() {
        //noinspection unchecked
        return (CheckGroup<T>) getFieldsetComponent();
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

        getCheckGroup().add(descriptionComponent, errorMessageComponent);
        customizeFieldset(getFieldsetComponent());
        getFieldsetComponent().add(new RdCheckboxGroupFieldsetBehavior(descriptionComponent, errorMessageComponent));

        getLegendComponent().add(RdCheckboxGroupLabelBehavior.INSTANCE);
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

        setIsInvalid(getFieldsetComponent().hasErrorMessage());
    }

    @Override
    protected CheckGroup<T> newFieldset(String id) {
        var checkGroup = new CheckGroup<>(id, model);
        checkGroup.setRenderBodyOnly(false);
        return checkGroup;
    }

    private Component newDescription(String id, @Nullable IModel<?> model) {
        return new Label(id, model).add(
            RdFormFieldDescriptionBehavior.INSTANCE,
            RdCheckboxGroupDescriptionBehavior.INSTANCE);
    }

    private Component newError(String id) {
        return createErrorMessageLabel(id, getFieldsetComponent())
            .add(RdCheckboxGroupErrorMessageBehavior.INSTANCE);
    }
}
