package nl.rotterdam.design_system.wicket.components.base;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

public abstract class TagNameClassComponentBehavior extends HeaderItemRenderingBehavior {

    private final String expectedTagName;
    private final String[] classNames;


    public TagNameClassComponentBehavior(String expectedTagName, String... classNames) {
        this.expectedTagName = expectedTagName;
        this.classNames = classNames;
    }


    public String[] getClassNames() {
        return classNames;
    }

    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", String.join(" ", this.getClassNames()), " ");
        }
    }

}
