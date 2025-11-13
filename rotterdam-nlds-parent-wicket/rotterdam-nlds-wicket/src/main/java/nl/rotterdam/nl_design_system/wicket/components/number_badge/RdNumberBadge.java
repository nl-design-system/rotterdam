package nl.rotterdam.nl_design_system.wicket.components.number_badge;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * <a href="https://nldesignsystem.nl/number-badge/">Number Badge component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdNumberBadge extends Label {

    /**
     * Constructor
     * @param id Wicket Id
     * @param number data to show
     */
    public RdNumberBadge(String id, Serializable number) {
        this(id, Model.of(number));
    }

    /**
     * Constructor
     * @param id Wicket Id
     * @param number data to show
     */
    public RdNumberBadge(String id, IModel<?> number) {
        super(id, number);
        add(new RdNumberBadgeBehavior());
    }
}
