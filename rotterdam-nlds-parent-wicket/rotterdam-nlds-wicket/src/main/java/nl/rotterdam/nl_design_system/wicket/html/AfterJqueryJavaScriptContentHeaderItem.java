package nl.rotterdam.nl_design_system.wicket.html;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptContentHeaderItem;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class AfterJqueryJavaScriptContentHeaderItem extends JavaScriptContentHeaderItem {

    /**
     * <p>
     * Cache the list and header item instead of recreating them every time the dependencies are retrieved. Assumes
     * the jQuery reference does not change while the application is running.
     * </p>
     */
    @Nullable
    private List<HeaderItem> dependencies;

    public AfterJqueryJavaScriptContentHeaderItem(String javaScript, String id) {
        super(javaScript, id);
    }

    @Override
    public List<HeaderItem> getDependencies() {
        // Not thread-safe, but creating the items a small number of times is not a problem.
        if (dependencies == null) {
            dependencies = List.of(forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()));
        }
        return dependencies;
    }
}
