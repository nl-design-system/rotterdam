package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.basic.Label;

class RdCheckboxGroupErrorMessageBehavior extends TagNameClassComponentBehavior<Label> {
    static final RdCheckboxGroupErrorMessageBehavior INSTANCE = new RdCheckboxGroupErrorMessageBehavior();

    private RdCheckboxGroupErrorMessageBehavior() {
        super("div", RdCheckboxGroupCss.ERROR_MESSAGE_ELEMENT);
    }
}
