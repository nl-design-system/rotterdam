package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldsetCss.LEGEND_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldsetCss.LEGEND_ELEMENT_HTML_LEGEND;

class RdFieldsetLegendBehavior extends TagNameClassComponentBehavior<Component> {
    
    static final RdFieldsetLegendBehavior INSTANCE = new RdFieldsetLegendBehavior();

    private RdFieldsetLegendBehavior() {
        super("legend", LEGEND_ELEMENT, LEGEND_ELEMENT_HTML_LEGEND);
    }
}
