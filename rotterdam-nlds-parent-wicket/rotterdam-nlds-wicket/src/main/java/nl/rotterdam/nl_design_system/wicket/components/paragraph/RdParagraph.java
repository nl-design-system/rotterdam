package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/paragraph/">NL Design System Paragraph component</a>.
 */
@SuppressWarnings("doclint:missing")
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdParagraph extends Label {

    public RdParagraph(String id, IModel<?> model) {
        super(id, model);
        add(RdParagraphBehavior.INSTANCE);
    }

    public RdParagraph(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public RdParagraph(String id, Serializable label, RdParagraphAppearance appearance) {
        this(id, Model.of(label), appearance);
    }

    public RdParagraph(String id, IModel<?> model, RdParagraphAppearance appearance) {
        super(id, model);
        add(new RdParagraphBehavior(appearance));
    }
}
