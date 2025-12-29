package nl.rotterdam.nl_design_system.wicket.components.code;

import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

public class RdCodeBorder extends Border {
    /**
     * Creates a new {@link RdCodeBorder} with the given component id.
     *
     * @param id the Wicket component id
     */
    public RdCodeBorder(String id) {
        super(id);
    }

    /**
     * Creates a new {@link RdCodeBorder} with the given component id and model.
     *
     * @param id    the Wicket component id
     * @param model the model providing the content or value for this border; may be {@code null}
     */
    public RdCodeBorder(String id, @Nullable IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(RdCodeBehavior.INSTANCE);
    }
}
