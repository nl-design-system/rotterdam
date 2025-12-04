package nl.rotterdam.nl_design_system.wicket.components.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdParagraphBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdParagraphBehavior.class,
        "@nl-design-system-candidate/paragraph-css/dist/paragraph.css"
    );

    static final RdParagraphBehavior INSTANCE = new RdParagraphBehavior();

    private RdParagraphBehavior() {
        super("p", RdParagraphCss.BASE);
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
