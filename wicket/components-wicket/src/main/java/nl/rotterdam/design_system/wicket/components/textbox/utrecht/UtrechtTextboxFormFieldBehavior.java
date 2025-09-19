package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtTextboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final UtrechtTextboxFormFieldBehavior INSTANCE = new UtrechtTextboxFormFieldBehavior();

    private UtrechtTextboxFormFieldBehavior() {
        // TODO this is incorrect. Style should be loaded on Textbox.
        super("div", "utrecht-form-field--text");
        addHeaderItem(cssReferenceHeaderItem(UtrechtTextboxFormFieldBehavior.class, "@utrecht/textbox-css/dist/index.css"));
    }

}
