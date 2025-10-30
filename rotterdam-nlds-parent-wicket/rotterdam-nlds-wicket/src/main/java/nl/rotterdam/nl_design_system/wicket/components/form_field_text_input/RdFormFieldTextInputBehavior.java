package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_text_input.RdFormFieldTexInputCss.DEFAULT;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

public class RdFormFieldTextInputBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final RdFormFieldTextInputBehavior INSTANCE = new RdFormFieldTextInputBehavior();

    private RdFormFieldTextInputBehavior() {
        super("div", DEFAULT);
    }
}
