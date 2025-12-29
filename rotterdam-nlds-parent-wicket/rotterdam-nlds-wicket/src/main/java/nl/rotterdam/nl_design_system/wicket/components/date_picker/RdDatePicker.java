package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converter.LocalDateTimeConverter;
import org.apache.wicket.util.string.Strings;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = HELP_WANTED, htmlCssImplementedBy = ROTTERDAM)
public class RdDatePicker extends AbstractTextComponent<LocalDateTime> {

    static class DatePickerLocalDateTimeConverter extends LocalDateTimeConverter {

        private static final DateTimeFormatter ISO_LOCAL_DATE_TIME_MINUTES =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        @Override
        protected DateTimeFormatter getDateTimeFormatter() {
            return ISO_LOCAL_DATE_TIME_MINUTES;
        }
    }

    private static final IConverter<LocalDateTime> DATE_TIME_CONVERTER = new DatePickerLocalDateTimeConverter();

    /**
     * Create a date picker instance.
     *
     * @param id the Wicket ID
     * @param model model for the date-time value
     */
    public RdDatePicker(String id, IModel<@Nullable LocalDateTime> model) {
        super(id, model);
    }


    @Override
    public <C> IConverter<C> getConverter(Class<C> type) {
        if (LocalDateTime.class.equals(type)) {
            //noinspection unchecked
            return (IConverter<C>) DATE_TIME_CONVERTER;
        }
        throw new IllegalArgumentException("Only LocalDateTime class is supported");
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
