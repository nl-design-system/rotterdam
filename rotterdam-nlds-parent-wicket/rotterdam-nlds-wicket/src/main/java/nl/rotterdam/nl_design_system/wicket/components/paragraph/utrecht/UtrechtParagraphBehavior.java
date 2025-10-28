package nl.rotterdam.nl_design_system.wicket.components.paragraph.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtParagraphBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtParagraphBehavior.class,
        "@utrecht/paragraph-css/dist/index.css"
    );

    public UtrechtParagraphBehavior() {
        super("p", RdParagraphCss.DEFAULT);
        addHeaderItem(CSS);
    }

    public UtrechtParagraphBehavior(UtrechtParagraphAppearance appearance) {
        super("p", toCss(appearance));
    }

    private static CssClassNames toCss(UtrechtParagraphAppearance appearance) {
        return switch (appearance) {
            case LEAD -> RdParagraphCss.LEAD;
        };
    }
}
