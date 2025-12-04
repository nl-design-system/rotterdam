package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.form.RadioGroup;

class RdRadioGroupDescriptionBehavior extends TagNameClassComponentBehavior<RadioGroup<?>> {
    static final RdRadioGroupDescriptionBehavior INSTANCE = new RdRadioGroupDescriptionBehavior();

    private RdRadioGroupDescriptionBehavior() {
        super("div", RdRadioGroupCss.DESCRIPTION_ELEMENT);
    }
}
