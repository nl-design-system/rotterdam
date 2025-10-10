package nl.rotterdam.design_system.wicket.components.number_badge.utrecht;

import java.io.Serializable;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtNumberBadge extends Label {

    public UtrechtNumberBadge(String id) {
        this(id, Model.of((String) null));
    }

    public UtrechtNumberBadge(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public UtrechtNumberBadge(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtNumberBadgeBehavior());
    }
}
