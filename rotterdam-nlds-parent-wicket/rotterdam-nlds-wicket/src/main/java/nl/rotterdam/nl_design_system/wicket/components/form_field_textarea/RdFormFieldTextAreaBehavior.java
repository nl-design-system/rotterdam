package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_textarea.RdFormFieldTextAreaCss.TEXTAREA;

/**
 * Behavior for the Form field text area.
 */
class RdFormFieldTextAreaBehavior extends TagNameClassComponentBehavior<Panel> {

    /**
     * Singleton instance.
     */
    static final RdFormFieldTextAreaBehavior INSTANCE = new RdFormFieldTextAreaBehavior();

    private RdFormFieldTextAreaBehavior() {
        super("div", TEXTAREA);
    }
}
