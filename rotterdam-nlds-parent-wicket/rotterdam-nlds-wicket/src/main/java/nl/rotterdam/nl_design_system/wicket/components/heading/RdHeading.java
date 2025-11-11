package nl.rotterdam.nl_design_system.wicket.components.heading;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;
import java.util.Set;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdHeading extends Label {
    private static final Set<String> ALLOWED_TAG_NAMES = Set.of("h1", "h2", "h3", "h4", "h5", "h6");

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

    @Override
    protected void onComponentTag(ComponentTag tag) {
        if (ALLOWED_TAG_NAMES.stream().noneMatch((allowedTagName) -> tag.getName().equalsIgnoreCase(allowedTagName)))
        {
            String msg = String.format("Component [%s] (path = [%s]) must be "
                + "applied to a tag of type [%s], not: %s", getId(), getPath(), "h1",
                tag.toUserDebugString());

            findMarkupStream().throwMarkupException(msg);
        }

        super.onComponentTag(tag);
    }
}
