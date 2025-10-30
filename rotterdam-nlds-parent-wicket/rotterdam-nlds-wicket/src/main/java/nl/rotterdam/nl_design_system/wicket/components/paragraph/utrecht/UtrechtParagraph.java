package nl.rotterdam.nl_design_system.wicket.components.paragraph.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import java.io.Serializable;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtParagraph extends Label {

    public UtrechtParagraph(String id, IModel<?> model) {
        super(id, model);
        add(new UtrechtParagraphBehavior());
    }

    public UtrechtParagraph(String id, Serializable label) {
        this(id, Model.of(label));
    }

    public UtrechtParagraph(String id, Serializable label, UtrechtParagraphAppearance appearance) {
        this(id, Model.of(label), appearance);
    }

    public UtrechtParagraph(String id, IModel<?> model, UtrechtParagraphAppearance appearance) {
        super(id, model);
        add(new UtrechtParagraphBehavior(appearance));
    }
}
