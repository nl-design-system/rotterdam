package nl.rotterdam.design_system.wicket.components.base;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class TagNameClassComponentBehavior extends Behavior {

    private final String expectedTagName;
    private final String[] classNames;

    private final List<CssReferenceHeaderItem> headerItems = new ArrayList<>();

    public TagNameClassComponentBehavior(String expectedTagName, String... classNames) {
        this.expectedTagName = expectedTagName;
        this.classNames = classNames;
    }

    public void addHeaderItem(CssReferenceHeaderItem headerItem) {
        if (headerItem == null) {
            throw new RuntimeException("Header item cannot be null");
        }
        headerItems.add(headerItem);
    }

    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", String.join(" ", classNames), " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        headerItems.forEach(response::render);
    }
}
