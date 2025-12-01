package nl.rotterdam.nl_design_system.wicket.internal.components.button_border;

import org.apache.wicket.Component;
import org.apache.wicket.DequeueContext;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.IMarkupFragment;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.TagUtils;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.parser.XmlTag;
import org.jspecify.annotations.Nullable;

/**
 * <p>
 * A border body container that can be reused by multiple {@link org.apache.wicket.markup.html.border.Border}-like
 * implementations.
 * </p>
 * <p>
 * NOTE: it is not complete generic yet and requires the borders to be in this package. Making {@link #rendering} public
 * (or adding a public getter) will allow border implementations to be in any package.
 * </p>
 * <p>
 * The implementation has been copied from
 * {@link org.apache.wicket.markup.html.border.Border.BorderBodyContainer BorderBodyContainer}, and adjusted where
 * needed.
 * </p>
 */
public class BorderBodyContainer extends WebMarkupContainer {
    private final Component markupProvider;

    /**
     * The markup
     */
    private transient @Nullable IMarkupFragment markup;

    // properly resolve borders added to borders
    boolean rendering;

    /**
     * Constructor
     *
     * @param id the Wicket ID
     */
    public BorderBodyContainer(final Component markupProvider, final String id) {
        super(id);
        this.markupProvider = markupProvider;
    }

    @Override
    protected void onComponentTag(final ComponentTag tag) {
        // Convert open-close to open-body-close
        if (tag.isOpenClose()) {
            tag.setType(XmlTag.TagType.OPEN);
            tag.setModified(true);
        }

        super.onComponentTag(tag);
    }

    @Override
    public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
        // skip the <wicket:body> body
        if (markupStream.getPreviousTag().isOpen()) {
            // Only RawMarkup is allowed within the preview region,
            // which gets stripped from output
            markupStream.skipRawMarkup();
        }

        // Get the <span wicket:id="myBorder"> markup and render that instead
        IMarkupFragment markup = markupProvider.getMarkup();
        MarkupStream stream = new MarkupStream(markup);
        ComponentTag tag = stream.getTag();
        stream.next();

        super.onComponentTagBody(stream, tag);
    }

    @Override
    protected void onRender() {
        rendering = true;

        try {
            super.onRender();
        } finally {
            rendering = false;
        }
    }

    /**
     * Get the &lt;wicket:body&gt; markup from the body's parent container
     */
    @Override
    public @Nullable IMarkupFragment getMarkup() {
        if (markup == null) {
            markup = findBody(getParent().getMarkup(null));
        }
        return markup;
    }

    /**
     * Search for &lt;wicket:'name' ...&gt; on the same level, but ignoring other "transparent"
     * tags such as &lt;wicket:enclosure&gt; etc.
     *
     * @param markup the markup to search in.
     * @return <code>null</code>, if not found.
     */
    private @Nullable IMarkupFragment findBody(final IMarkupFragment markup) {
        MarkupStream stream = new MarkupStream(markup);

        // Skip any raw markup
        stream.skipUntil(ComponentTag.class);

        // Skip <wicket:border>
        stream.next();

        while (stream.skipUntil(ComponentTag.class)) {
            ComponentTag tag = stream.getTag();
            if (tag.isOpen() || tag.isOpenClose()) {
                if (TagUtils.isWicketBodyTag(tag)) {
                    return stream.getMarkupFragment();
                }
            }

            stream.next();
        }

        return null;
    }

    /**
     * Get the child markup which must be in between the &lt;span wicktet:id="myBorder"&gt; tags
     */
    @Override
    public @Nullable IMarkupFragment getMarkup(final @Nullable Component child) {
        IMarkupFragment markup = markupProvider.getMarkup();
        if (markup == null) {
            return null;
        }

        if (child == null) {
            return markup;
        }

        return markup.find(child.getId());
    }

    @Override
    public DequeueContext newDequeueContext() {
        throw new IllegalStateException("Do not use queuing with " + getClass().getSimpleName());
    }

    @Override
    public Component findComponentToDequeue(ComponentTag tag) {
        throw new IllegalStateException("Do not use queuing with " + getClass().getSimpleName());
    }
}
