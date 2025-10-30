package nl.rotterdam.nl_design_system.wicket.components.base;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public abstract class HeaderItemRenderingBehavior extends Behavior {

    private final List<CssReferenceHeaderItem> headerItems = new ArrayList<>();

    public void addHeaderItem(CssReferenceHeaderItem headerItem) {
        requireNonNull(headerItem, "Header item cannot be null");
        headerItems.add(headerItem);
    }

    @Override
    public final void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        headerItems.forEach(response::render);
    }
}
