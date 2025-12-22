package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/paragraph/">Paragraph</a>.
 * </p>
 */
@SuppressWarnings("doclint:missing")
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdParagraphBorder extends Border {

    public RdParagraphBorder(String id) {
        super(id);
        add(RdParagraphBehavior.INSTANCE);
    }

    public RdParagraphBorder(String id, RdParagraphAppearance appearance) {
        super(id);
        add(new RdParagraphBehavior(appearance));
    }

    public RdParagraphBorder(String id, @Nullable IModel<?> model) {
        super(id, model);
        add(RdParagraphBehavior.INSTANCE);
    }

    public RdParagraphBorder(String id, @Nullable IModel<?> model, RdParagraphAppearance appearance) {
        super(id, model);
        add(new RdParagraphBehavior(appearance));
    }
}
