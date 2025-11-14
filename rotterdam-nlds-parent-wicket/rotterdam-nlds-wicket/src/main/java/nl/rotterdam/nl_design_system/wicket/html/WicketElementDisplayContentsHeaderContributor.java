/*
 * Copyright 2025, Gemeente Rotterdam, Nederland
 *
 * All rights reserved. Without explicit written consent beforehand of
 * the gemeente Rotterdam nothing of this software and source code may
 * be reproduced, adapted, distributed, and/or communicated to the public,
 * except in case of a statutory limitation of copyright.
 */

package nl.rotterdam.nl_design_system.wicket.html;

import nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.request.resource.CssResourceReference;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <p>
 * Adds a CSS reference to a rendered page that ensures that all Wicket tags that may appear in rendered HTML will have
 * CSS property <code>display</code> set to <code>contents</code>. This makes the tags transparent for things like
 * flexbox and grid, ensuring content is laid out properly.
 * </p>
 * <p>
 * You only need to add this header contributor if Wicket is running in
 * {@link RuntimeConfigurationType#DEVELOPMENT DEVELOPMENT} mode.
 * </p>
 */
public class WicketElementDisplayContentsHeaderContributor implements IHeaderContributor {
    private WicketElementDisplayContentsHeaderContributor() {
    }

    private static final CssReferenceHeaderItem WICKET_ELEMENT_DISPLAY_CONTENTS_CSS_REFERENCE_ITEM =
        cssReferenceHeaderItem(WicketElementDisplayContentsHeaderContributor.class, "wicket-element-display-contents.css");

    /**
     * Singleton instance.
     */
    public static final WicketElementDisplayContentsHeaderContributor INSTANCE = new WicketElementDisplayContentsHeaderContributor();

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(WICKET_ELEMENT_DISPLAY_CONTENTS_CSS_REFERENCE_ITEM);
    }
}
