package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.ROTTERDAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.HELP_WANTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

/**
 * <a href="https://www.npmjs.com/package/@gemeente-rotterdam/date-picker-element">Date Picker Element</a>
 * Wicket components.
 *
 * <p>Uses the {@code <rods-date-picker>} web component from the
 * {@code @gemeente-rotterdam/date-picker-element} package.
 * </p>
 *
 * <p>Technically, this is a datetime-local text input component with an alternative
 * presentation using a web component tag name.
 * </p>
 *
 * @param <T> the model object type (typically String for date-time values)
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = HELP_WANTED, htmlCssImplementedBy = ROTTERDAM)
public class RdDatePicker<T extends @Nullable Object> extends AbstractTextComponent<T> {

    /**
     * Create a date picker instance.
     *
     * @param id the Wicket ID
     * @param model model for the date-time value
     */
    public RdDatePicker(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(RdDatePickerBehavior.INSTANCE);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        String value = getValue();
        if (!Strings.isEmpty(value)) {
            tag.put("value", value);
        }
    }
}
