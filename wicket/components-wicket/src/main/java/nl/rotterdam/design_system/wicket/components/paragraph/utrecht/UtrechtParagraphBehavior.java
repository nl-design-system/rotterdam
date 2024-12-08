package nl.rotterdam.design_system.wicket.components.paragraph.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtParagraphBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtParagraphBehavior.class,
        "@utrecht/paragraph-css/dist/index.css"
    );

    public UtrechtParagraphBehavior() {
        super("p", "utrecht-paragraph");
        addHeaderItem(CSS);
    }

    public UtrechtParagraphBehavior(UtrechtParagraphAppearance appearance) {
        super("p", "utrecht-paragraph", "utrecht-paragraph--" + appearance.appearance);
    }
}
