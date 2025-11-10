package nl.rotterdam.nl_design_system.wicket.components.number_badge;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdNumberBadge extends Label {

    public RdNumberBadge(String id) {
        this(id, Model.of((String) null));
    }

    public RdNumberBadge(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public RdNumberBadge(String id, IModel<?> model) {
        super(id, model);
        add(new RdNumberBadgeBehavior());
    }
}
