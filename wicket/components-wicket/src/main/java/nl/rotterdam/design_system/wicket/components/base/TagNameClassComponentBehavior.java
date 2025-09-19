package nl.rotterdam.design_system.wicket.components.base;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

import java.util.Collection;
import java.util.List;

public abstract class TagNameClassComponentBehavior<T extends Component> extends HeaderItemRenderingBehavior {

    private final String requiredTagName;
    private final String[] classNames;

    public TagNameClassComponentBehavior(String requiredTagName, String... classNames) {
        this.requiredTagName = requiredTagName;
        this.classNames = classNames;
    }

    public final void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!requiredTagName.equals(tag.getName())) {
            throw new IllegalStateException("Expected tag name '" + requiredTagName + "' but found '" + tag.getName() + "' for component: " + component.getId());
        }

        if (tag.isClose()) {
            return;
        }

        List<String> dynamicClassNames = customizeComponentAndReturnClasses((T) component, tag);

        if (classNames.length > 0 || !dynamicClassNames.isEmpty()) {
            tag.append("class", joinAll(classNames, dynamicClassNames), " ");
        }
    }

    /**
     * Efficient conversion of an array and a collection to a single space-separated string.
     */
    private static String joinAll(String[] arr, Collection<String> col) {
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            if (s != null && !s.isEmpty()) {
                if (!sb.isEmpty()) sb.append(' ');
                sb.append(s);
            }
        }

        for (String s : col) {
            if (s != null && !s.isEmpty()) {
                if (!sb.isEmpty()) sb.append(' ');
                sb.append(s);
            }
        }

        return sb.toString();
    }

    /**
     * Add dynamic classes based on the state of the component.
     */
    protected List<String> customizeComponentAndReturnClasses(T component, ComponentTag tag) {
        return List.of();
    }

}
