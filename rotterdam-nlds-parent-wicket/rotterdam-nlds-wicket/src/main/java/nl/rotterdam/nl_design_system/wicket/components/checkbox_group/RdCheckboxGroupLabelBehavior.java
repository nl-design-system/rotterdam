package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.basic.Label;

class RdCheckboxGroupLabelBehavior extends TagNameClassComponentBehavior<Label> {
    static final RdCheckboxGroupLabelBehavior INSTANCE = new RdCheckboxGroupLabelBehavior();

    private RdCheckboxGroupLabelBehavior() {
        super("legend", RdCheckboxGroupCss.LABEL_ELEMENT);
    }
}
