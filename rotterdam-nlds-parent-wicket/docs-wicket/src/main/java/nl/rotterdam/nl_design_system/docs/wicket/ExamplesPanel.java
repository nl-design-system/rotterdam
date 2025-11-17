package nl.rotterdam.nl_design_system.docs.wicket;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class ExamplesPanel extends Panel {
    public ExamplesPanel(String id) {
        super(id);
    }

    public ExamplesPanel(String id, IModel<?> model) {
        super(id, model);
    }

    /**
     * <p>
     * Get the class of the object shown by this examples panel. If the panel shows different objects, return the class
     * of the most general/simple object.
     * </p>
     * <p>
     * The class is only used to retrieve the package, which is then used to generate a URI to the source of the shown
     * object. If this panel shows objects residing in different packages, the storybook will only point to the source
     * of the returned class.
     * </p>
     *
     * @return the class of (one of) the examples shown by this panel.
     */
    public abstract Class<?> getImplementationClass();
}
