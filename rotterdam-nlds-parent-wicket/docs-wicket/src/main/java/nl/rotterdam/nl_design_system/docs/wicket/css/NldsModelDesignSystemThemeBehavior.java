package nl.rotterdam.nl_design_system.docs.wicket.css;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;

public class NldsModelDesignSystemThemeBehavior extends Behavior {
    private final IModel<DesignSystemTheme> themeModel;

    public NldsModelDesignSystemThemeBehavior(IModel<DesignSystemTheme> themeModel) {
        this.themeModel = themeModel;
    }


    @Override
    public final void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        // Render all resource references, so an Ajax update after a refresh will use the correct style.
        for (DesignSystemTheme theme : DesignSystemTheme.values()) {
            theme.getBehavior().renderHead(component, response);
        }
    }

    @Override
    public final void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        themeModel.getObject().getBehavior().onComponentTag(component, tag);
    }
}
