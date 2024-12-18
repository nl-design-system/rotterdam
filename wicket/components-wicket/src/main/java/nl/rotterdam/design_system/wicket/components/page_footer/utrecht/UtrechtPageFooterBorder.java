package nl.rotterdam.design_system.wicket.components.page_footer.utrecht;

import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageFooterBorder extends Border {

    public UtrechtPageFooterBorder(String id) {
        super(id);
        add(new UtrechtPageFooterBehavior());
    }
}
