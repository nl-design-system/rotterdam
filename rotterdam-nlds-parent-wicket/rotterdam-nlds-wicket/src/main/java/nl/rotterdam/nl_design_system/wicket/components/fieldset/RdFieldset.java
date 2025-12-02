package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/fieldset/">Fieldset</a> with a legend. This must be attached to
 * <code>&lt;div&gt;</code>. The content of the tag must be the fields of the fieldset.
 * </p>
 * <table>
 *     <caption>Options of a fieldset</caption>
 *     <thead>
 *         <tr>
 *             <th scope="col">Option</th>
 *             <th scope="col">Description</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>Is invalid</td>
 *             <td>Whether one or more of the fields in the fieldset has an invalid value.</td>
 *         </tr>
 *         <tr>
 *             <td>Is section</td>
 *             <td>Whether the fieldset itself is a section.</td>
 *         </tr>
 *     </tbody>
 * </table>
 * <p>
 * Based on the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-fieldset--docs">
 * CSS implementation of Utrecht</a>.
 * </p>
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFieldset extends Border {
    private final WebMarkupContainer fieldsetComponent;
    private final Component legendComponent;
    private boolean isInvalid;
    private boolean isSection;

    /**
     * <p>
     * Create an instance without a model for the legend.
     * </p>
     * 
     * @param id the Wicket ID.
     */
    public RdFieldset(String id) {
        this(id, null);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID and model for the legend.
     * </p>
     * 
     * @param id the Wicket ID.
     * @param model the model for the legend.
     */
    public RdFieldset(String id, @Nullable IModel<?> model) {
        super(id, model);
        
        add(RdFieldsetBehavior.INSTANCE);
        fieldsetComponent = newFieldset("fieldset");
        legendComponent = newLegend("legend", getDefaultModel());
    }

    /**
     * <p>
     * Get the component attached to <code>&lt;fieldset&gt;</code>.
     * </p>
     * 
     * @return the fieldset component.
     */
    public Component getFieldsetComponent() {
        return fieldsetComponent;
    }
    
    protected WebMarkupContainer getFieldsetComponentInternal() {
        return fieldsetComponent;
    }

    /**
     * <p>
     * Get the component attached to <code>&lt;legend&gt;</code>.
     * </p>
     *
     * @return the legend component.
     */
    public Component getLegendComponent() {
        return legendComponent;
    }

    /**
     * <p>
     * Whether one or more fields in the fieldset has an invalid value.
     * </p>
     * 
     * @return <code>true</code> if the fieldset contains an invalid value, <code>false</code> otherwise.
     */
    public boolean isInvalid() {
        return isInvalid;
    }

    /**
     * <p>
     * Set whether one or more fields in the fieldset has an invalid value.
     * </p>
     *
     * @param isInvalid <code>true</code> if the fieldset contains an invalid value, <code>false</code> otherwise.
     */
    public void setIsInvalid(boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    /**
     * <p>
     * Whether the fieldset itself is a section.
     * </p>
     * 
     * @return <code>true</code> if the fieldset is a section, <code>false</code> otherwise.
     */
    public boolean isSection() {
        return isSection;
    }

    /**
     * <p>
     * Set whether the fieldset itself is a section.
     * </p>
     *
     * @param isSection <code>true</code> if the fieldset is a section, <code>false</code> otherwise.
     */
    public void setIsSection(boolean isSection) {
        this.isSection = isSection;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        addToBorder(fieldsetComponent);
        fieldsetComponent.add(legendComponent);
    }
    
    protected WebMarkupContainer newFieldset(String id) {
        var fieldset = new WebMarkupContainer(id);
        customizeFieldset(fieldset);
        return fieldset;
    }

    protected void customizeFieldset(Component fieldset) {
        fieldset.add(RdFieldsetFieldsetBehavior.INSTANCE);
    }

    private Component newLegend(String id, @Nullable IModel<?> model) {
        var legend = new Label(id, model);
        legend.add(RdFieldsetLegendBehavior.INSTANCE);
        return legend;
    }
}
