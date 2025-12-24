package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.basic.Label;

class RdRadioGroupErrorMessageBehavior extends TagNameClassComponentBehavior<Label> {
    static final RdRadioGroupErrorMessageBehavior INSTANCE = new RdRadioGroupErrorMessageBehavior();

    private RdRadioGroupErrorMessageBehavior() {
        super("div", RdRadioGroupCss.ERROR_MESSAGE_ELEMENT);
    }
}
