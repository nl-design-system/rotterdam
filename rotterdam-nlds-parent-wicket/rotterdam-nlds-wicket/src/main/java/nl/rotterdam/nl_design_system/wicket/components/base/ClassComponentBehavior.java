package nl.rotterdam.nl_design_system.wicket.components.base;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class ClassComponentBehavior<T extends Component> extends HeaderItemRenderingBehavior {

    private final String[] classNames;

    protected ClassComponentBehavior(CssClassNames... classNames) {
        this.classNames = Arrays.stream(classNames).map(CssClassNames::getClassNames).toArray(String[]::new);
    }

    @Override
    public final void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (tag.isClose()) {
            return;
        }

        @SuppressWarnings("unchecked")
        List<CssClassNames> dynamicClassNames = customizeComponentAndReturnClasses((T) component, tag);

        if (classNames.length > 0 || !dynamicClassNames.isEmpty()) {
            tag.append(
                "class",
                joinAll(classNames, dynamicClassNames.stream().map(CssClassNames::getClassNames).toList()),
                " "
            );
        }
    }

    /**
     * Efficient conversion of an array and a collection to a single space-separated string.
     */
    private static String joinAll(@Nullable String[] arr, Collection<@Nullable String> col) {
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
    protected List<CssClassNames> customizeComponentAndReturnClasses(T component, ComponentTag tag) {
        return List.of();
    }
}
