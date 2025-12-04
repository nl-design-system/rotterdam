package nl.rotterdam.nl_design_system.wicket.components.select;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/select/">Select</a>. This must be attached to <code>&lt;select&gt;</code>.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-select--docs">CSS implementation of Utrecht</a>.
 * </p>
 * 
 * @param <T> the model object type.
 */
public class RdSelect<T> extends DropDownChoice<T> {
    /**
     * <p>
     * Create an instance without a model and choices, and the default renderer.
     * </p>
     * 
     * @param id the Wicket ID.
     */
    public RdSelect(String id) {
        this(id, null, (IModel<List<T>>) null, null);
    }

    /**
     * <p>
     * Create an instance with the given choices, and the default renderer. 
     * </p>
     *
     * @param id the Wicket ID.
     * @param choices the possible choices.
     */
    public RdSelect(String id, List<? extends T> choices) {
        this(id, null, new ListModel<>(choices), null);
    }

    /**
     * <p>
     * Create an instance with the given choices and renderer. 
     * </p>
     *
     * @param id the Wicket ID.
     * @param choices the possible choices.
     * @param renderer the renderer with which to render the choices.
     */
    public RdSelect(String id, List<? extends T> choices, @Nullable IChoiceRenderer<? super T> renderer) {
        this(id, null, new ListModel<>(choices), renderer);
    }

    /**
     * <p>
     * Create an instance with the given model and choices, and the default renderer.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model.
     * @param choices the possible choices.
     */
    public RdSelect(String id, @Nullable IModel<T> model, List<? extends T> choices) {
        this(id, model, new ListModel<>(choices), null);
    }

    /**
     * <p>
     * Create an instance with the given model, choices and renderer. 
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model.
     * @param choices the possible choices.
     * @param renderer the renderer with which to render the choices.
     */
    public RdSelect(String id, @Nullable IModel<T> model, List<? extends T> choices, @Nullable IChoiceRenderer<? super T> renderer) {
        this(id, model, new ListModel<>(choices), renderer);
    }

    /**
     * <p>
     * Create an instance with the given choices, and the default renderer.
     * </p>
     *
     * @param id the Wicket ID.
     * @param choices the possible choices.
     */
    public RdSelect(String id, @Nullable IModel<? extends List<? extends T>> choices) {
        this(id, null, choices, null);
    }

    /**
     * <p>
     * Create an instance with the given model and choices, and the default renderer.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model.
     * @param choices the possible choices.
     */
    public RdSelect(String id,@Nullable  IModel<T> model, @Nullable IModel<? extends List<? extends T>> choices) {
        this(id, model, choices, null);
    }

    /**
     * <p>
     * Create an instance with the given choices and renderer.
     * </p>
     *
     * @param id the Wicket ID.
     * @param choices the possible choices.
     * @param renderer the renderer with which to render the choices.
     */
    public RdSelect(String id, @Nullable IModel<? extends List<? extends T>> choices, @Nullable IChoiceRenderer<? super T> renderer) {
        this(id, null, choices, renderer);
    }

    /**
     * <p>
     * Create an instance with the given model, choices and renderer.
     * </p>
     *
     * @param id the Wicket ID.
     * @param model the model.
     * @param choices the possible choices.
     * @param renderer the renderer with which to render the choices.
     */
    public RdSelect(String id, @Nullable IModel<T> model, @Nullable IModel<? extends List<? extends T>> choices, @Nullable IChoiceRenderer<? super T> renderer) {
        super(id, model, choices, renderer);
        
        add(RdSelectBehavior.INSTANCE);
    }
}
