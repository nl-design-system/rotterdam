package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.basic.Label;

class RdCheckboxGroupDescriptionBehavior extends TagNameClassComponentBehavior<Label> {
    static final RdCheckboxGroupDescriptionBehavior INSTANCE = new RdCheckboxGroupDescriptionBehavior();

    private RdCheckboxGroupDescriptionBehavior() {
        super("div", RdCheckboxGroupCss.DESCRIPTION_ELEMENT);
    }
}
