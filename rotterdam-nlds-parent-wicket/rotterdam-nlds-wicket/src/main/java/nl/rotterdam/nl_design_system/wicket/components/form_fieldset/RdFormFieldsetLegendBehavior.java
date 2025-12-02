package nl.rotterdam.nl_design_system.wicket.components.form_fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldsetCss.LEGEND_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldsetCss.LEGEND_ELEMENT_HTML_LEGEND;

class RdFormFieldsetLegendBehavior extends TagNameClassComponentBehavior<Component> {
    
    static final RdFormFieldsetLegendBehavior INSTANCE = new RdFormFieldsetLegendBehavior();

    private RdFormFieldsetLegendBehavior() {
        super("legend", LEGEND_ELEMENT, LEGEND_ELEMENT_HTML_LEGEND);
    }
}
