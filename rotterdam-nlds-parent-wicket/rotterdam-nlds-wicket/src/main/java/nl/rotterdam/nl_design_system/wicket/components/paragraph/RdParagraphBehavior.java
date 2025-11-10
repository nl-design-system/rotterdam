package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class RdParagraphBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdParagraphBehavior.class,
        "@utrecht/paragraph-css/dist/index.css"
    );

    public RdParagraphBehavior() {
        super("p", RdParagraphCss.DEFAULT);
        addHeaderItem(CSS);
    }

    public RdParagraphBehavior(RdParagraphAppearance appearance) {
        super("p", toCss(appearance));
    }

    private static CssClassNames toCss(RdParagraphAppearance appearance) {
        return switch (appearance) {
            case LEAD -> RdParagraphCss.LEAD;
        };
    }
}
