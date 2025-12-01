package nl.rotterdam.nl_design_system.wicket.components.data_badge;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/data-badge/">Data Badge</a> component.
 * TODO use TagNameClassComponentBehavior.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdDataBadgeBehavior extends Behavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdDataBadgeBehavior.class,
        "@nl-design-system-candidate/data-badge-css/dist/data-badge.css"
    );

    private final String expectedTagName;
    private final String className;

    /**
     * Create instance.
     */
    public RdDataBadgeBehavior() {
        this.expectedTagName = "span";
        this.className = "nl-data-badge";
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(CSS);
    }
}
