package nl.rotterdam.design_system.wicket.components.form_field_text_input;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_text_input.RdFormFieldTexInputCss.UTRECHT_FORM_FIELD_TEXT;

public class RdFormFieldTextInputBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final RdFormFieldTextInputBehavior INSTANCE = new RdFormFieldTextInputBehavior();

    private RdFormFieldTextInputBehavior() {
        super("div", UTRECHT_FORM_FIELD_TEXT);
    }

}
