
package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class UtrechtTextbox<T> extends TextField<T> {

    public UtrechtTextbox(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(UtrechtTextboxBehavior.INSTANCE);
    }

}
