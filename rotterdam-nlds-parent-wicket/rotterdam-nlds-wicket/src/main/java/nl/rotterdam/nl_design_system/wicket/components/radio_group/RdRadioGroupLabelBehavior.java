package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.form.RadioGroup;

class RdRadioGroupLabelBehavior extends TagNameClassComponentBehavior<RadioGroup<?>> {
    static final RdRadioGroupLabelBehavior INSTANCE = new RdRadioGroupLabelBehavior();

    private RdRadioGroupLabelBehavior() {
        super("legend", RdRadioGroupCss.LABEL_ELEMENT);
    }
}
