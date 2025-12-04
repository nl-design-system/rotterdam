package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

class RdRadioGroupBehavior extends TagNameClassComponentBehavior<RdRadioGroup<?>> {
    static final RdRadioGroupBehavior INSTANCE = new RdRadioGroupBehavior();

    private RdRadioGroupBehavior() {
        super("div", RdRadioGroupCss.BASE);
    }
}
