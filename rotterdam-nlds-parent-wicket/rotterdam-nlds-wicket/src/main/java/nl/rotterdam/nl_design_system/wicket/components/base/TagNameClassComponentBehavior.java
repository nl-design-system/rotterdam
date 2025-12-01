package nl.rotterdam.nl_design_system.wicket.components.base;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Base behavior class often useful when creating NL Design System Components.
 *
 * <p>Often there are multiple wicket components that can be used which have common behavior. Examples</p>
 * <dl>
 *     <dt>Button</dt>
 *     <dd>Has Ajax Button and full page refresh Button</dd>
 *     <dt>Links</dt>
 *     <dd>Has bookmarkable links, Ajax links and full page refresh Link instances</dd>
 * </dl>
 *
 * <p>By adding the common behavior in a Behavior, this logic can be shared.</p>
 *
 * <p>Often behaviors can be a Singleton, further reducing object creation during Page instantiation.</p>
 *
 * @param <T> the expected component type.
 */
public abstract class TagNameClassComponentBehavior<T extends Component> extends HeaderItemRenderingBehavior {

    private final String requiredTagName;
    private final String classNames;

    /**
     * Maak een nieuwe instantie
     * @param requiredTagName
     *  tag name required in markup. Will throw exception if incorrect tag name is used
     * @param classNames
     *  CSS class names to be added by default
     */
    protected TagNameClassComponentBehavior(String requiredTagName, CssClassNames... classNames) {
        if (classNames.length < 1) {
            throw new IllegalArgumentException("`classNames` must have at least 1 element.");
        }
        this.requiredTagName = requiredTagName;
        this.classNames = Arrays.stream(classNames).map(CssClassNames::getClassNames).collect(Collectors.joining(" "));
    }

    public String getClassNames() {
        return classNames;
    }

    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!requiredTagName.equals(tag.getName())) {
            throw new IllegalStateException(
                "Expected tag name '" +
                requiredTagName +
                "' but found '" +
                tag.getName() +
                "' for component: " +
                component.getId()
            );
        }

        if (tag.isClose()) {
            return;
        }

        @SuppressWarnings("unchecked")
        List<CssClassNames> dynamicClassNames = customizeComponentAndReturnClasses((T) component, tag);

        String allClassNames;
        if (dynamicClassNames.isEmpty()) {
            allClassNames = classNames;
        } else {
            allClassNames = joinAll(classNames, dynamicClassNames.stream().map(CssClassNames::getClassNames).toList()); 
        }
        tag.append("class", allClassNames, " ");
    }

    private static String joinAll(String classNames, Collection<String> dynamicClassNames) {
        var allClassNamesBuilder = new StringBuilder(100);

        allClassNamesBuilder.append(classNames);

        for (var dynamicClassName : dynamicClassNames) {
            allClassNamesBuilder.append(' ');
            allClassNamesBuilder.append(dynamicClassName);
        }

        return allClassNamesBuilder.toString();
    }

    /**
     * Add dynamic classes based on the state of the component.
     * @param component currently being in rendering of componentTag
     * @param tag the html tag representation
     */
    protected List<CssClassNames> customizeComponentAndReturnClasses(T component, ComponentTag tag) {
        return List.of();
    }
}
