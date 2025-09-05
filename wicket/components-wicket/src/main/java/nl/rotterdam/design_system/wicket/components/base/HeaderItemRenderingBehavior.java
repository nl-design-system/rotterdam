package nl.rotterdam.design_system.wicket.components.base;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class HeaderItemRenderingBehavior extends Behavior {

    private final List<CssReferenceHeaderItem> headerItems = new ArrayList<>();

    public void addHeaderItem(CssReferenceHeaderItem headerItem) {
        if (headerItem == null) {
            throw new RuntimeException("Header item cannot be null");
        }
        headerItems.add(headerItem);
    }

    @Override
    public final void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        headerItems.forEach(response::render);
    }

}
