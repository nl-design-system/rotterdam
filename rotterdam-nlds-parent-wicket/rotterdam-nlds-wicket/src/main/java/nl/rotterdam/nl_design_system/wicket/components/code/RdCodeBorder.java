package nl.rotterdam.nl_design_system.wicket.components.code;

import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

public class RdCodeBorder extends Border {
    public RdCodeBorder(String id) {
        super(id);
    }

    public RdCodeBorder(String id, @Nullable IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(RdCodeBehavior.INSTANCE);
    }
}
