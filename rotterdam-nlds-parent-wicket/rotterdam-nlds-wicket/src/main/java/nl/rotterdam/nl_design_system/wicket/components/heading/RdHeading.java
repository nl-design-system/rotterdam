package nl.rotterdam.nl_design_system.wicket.components.heading;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdHeading extends Label {

    public RdHeading(String id, int level) {
        this(id, Model.of((String) null), level);
    }

    public RdHeading(String id, Serializable label, int level) {
        this(id, Model.of(label), level);
    }

    public RdHeading(String id, IModel<?> model, int level) {
        super(id, model);
        add(RdHeadingBehavior.heading(level));
    }
}
