package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

class RdCheckboxGroupBehavior extends TagNameClassComponentBehavior<RdCheckboxGroup<?>> {
    static final RdCheckboxGroupBehavior INSTANCE = new RdCheckboxGroupBehavior();

    private RdCheckboxGroupBehavior() {
        super("div", RdCheckboxGroupCss.BASE);
    }
}
