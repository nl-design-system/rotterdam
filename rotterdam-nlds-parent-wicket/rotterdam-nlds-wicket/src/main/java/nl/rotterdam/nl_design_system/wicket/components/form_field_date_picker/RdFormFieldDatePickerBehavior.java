package nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker.RdFormFieldDatePickerCss.DATE_PICKER;

/**
 * Behavior for the Form field date picker.
 */
class RdFormFieldDatePickerBehavior extends TagNameClassComponentBehavior<Panel> {

    /**
     * Singleton instance.
     */
    static final RdFormFieldDatePickerBehavior INSTANCE = new RdFormFieldDatePickerBehavior();

    private RdFormFieldDatePickerBehavior() {
        super("div", DATE_PICKER);
    }
}
