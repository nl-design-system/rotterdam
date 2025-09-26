package nl.rotterdam.design_system.wicket.components.heading.utrecht;

import java.io.Serializable;

import nl.rotterdam.design_system.wicket.components.component_state.EstafetteState;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;

@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY)
public class UtrechtHeading extends Label {

    public UtrechtHeading(String id, int level) {
        this(id, Model.of((String) null), level);
    }

    public UtrechtHeading(String id, Serializable label, int level) {
        this(id, Model.of(label), level);
    }

    public UtrechtHeading(String id, IModel<?> model, int level) {
        super(id, model);
        add(UtrechtHeadingBehavior.heading(level));
    }
}
