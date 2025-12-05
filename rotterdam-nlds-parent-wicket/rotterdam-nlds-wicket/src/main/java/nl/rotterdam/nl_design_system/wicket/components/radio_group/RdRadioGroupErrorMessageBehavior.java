package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.form.RadioGroup;

class RdRadioGroupErrorMessageBehavior extends TagNameClassComponentBehavior<RadioGroup<?>> {
    static final RdRadioGroupErrorMessageBehavior INSTANCE = new RdRadioGroupErrorMessageBehavior();

    private RdRadioGroupErrorMessageBehavior() {
        super("div", RdRadioGroupCss.ERROR_MESSAGE_ELEMENT);
    }
}
