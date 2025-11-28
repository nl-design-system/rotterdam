package nl.rotterdam.nl_design_system.wicket.components.number_badge;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/number-badge/">Number Badge component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdNumberBadge extends Label {

    /**
     * Constructor
     * @param id the Wicket ID
     * @param number data to show
     */
    public RdNumberBadge(String id, @Nullable Serializable number) {
        this(id, Model.of(number));
    }

    /**
     * Constructor
     * @param id the Wicket ID
     * @param number data to show
     */
    public RdNumberBadge(String id, IModel<?> number) {
        super(id, number);
        add(new RdNumberBadgeBehavior());
    }
}
