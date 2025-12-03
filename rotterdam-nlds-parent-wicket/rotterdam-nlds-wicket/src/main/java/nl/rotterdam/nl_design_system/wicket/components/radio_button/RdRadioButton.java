package nl.rotterdam.nl_design_system.wicket.components.radio_button;

import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/radio-button/">Radio Button</a>. This must be attached to
 * <code>&lt;input&gt;</code> with attribute <code>type</code> set to <code>radio</code>.
 * </p>
 * <p>
 * Based on the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-radio-button--docs">CSS implementation of Utrecht</a>.
 * </p>
 * @param <T> the model object type.
 */
public class RdRadioButton<T> extends Radio<T> {
    /**
     * <p>
     * Create an instance with the given Wicket ID. The radio group will be searched for in the ancestors.
     * </p>
     * 
     * @param id the Wicket ID.
     */
    public RdRadioButton(String id) {
        this(id, null, null);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID and model. The radio group will be searched for in the ancestors.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the (optional) model.
     */
    public RdRadioButton(String id, @Nullable IModel<T> model) {
        this(id, model, null);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID and radio group.
     * </p>
     *
     * @param id the Wicket ID.
     * @param group the (optional) group. If <code>group</code> is <code>null</code>, the radio group will be searched
     *             for in the ancestors.
     */
    public RdRadioButton(String id, @Nullable RadioGroup<T> group) {
        this(id, null, group);
    }

    /**
     * <p>
     * Create an instance with the given Wicket ID, model and radio group.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the (optional) model.
     * @param group the (optional) group. If <code>group</code> is <code>null</code>, the radio group will be searched
     *             for in the ancestors.
     */
    public RdRadioButton(String id, @Nullable IModel<T> model, @Nullable RadioGroup<T> group) {
        super(id, model, group);
        
        add(RdRadioButtonBehavior.INSTANCE);
    }
}
