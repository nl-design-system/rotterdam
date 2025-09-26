package nl.rotterdam.design_system.wicket.components.link.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.component.IRequestablePage;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY)
public class UtrechtLink<T, C extends IRequestablePage> extends Link<T> {

    public Class<C> webPage = null;
    public boolean placeholder = false;

    public UtrechtLink(final String id) {
        super(id);
    }

    public UtrechtLink(final String id, IModel<T> model) {
        super(id, model);
    }

    public UtrechtLink(final String id, IModel<T> model, Class<C> webPage) {
        super(id, model);
        this.webPage = webPage;
    }

    @Override
    public void onClick() {
        if (this.webPage != null) {
            setResponsePage(this.webPage);
        }
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new UtrechtLinkBehavior());
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            tag.append("class", "utrecht-link--placeholder", " ");
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
        }
    }

    @Override
    public boolean isEnabled() {
        // Use the `isEnabled()` from `Link` to add an extra condition to disable
        // the link: when it is a placeholder.
        return super.isEnabled() && !this.placeholder;
    }

    public void setPlaceholder(boolean enabled) {
        this.placeholder = enabled;
    }
}
