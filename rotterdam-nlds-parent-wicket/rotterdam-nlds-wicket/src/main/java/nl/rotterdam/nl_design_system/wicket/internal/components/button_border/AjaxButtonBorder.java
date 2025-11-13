package nl.rotterdam.nl_design_system.wicket.internal.components.button_border;

import org.apache.wicket.Component;
import org.apache.wicket.DequeueTagAction;
import org.apache.wicket.IQueueRegion;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.IMarkupFragment;
import org.apache.wicket.markup.MarkupElement;
import org.apache.wicket.markup.MarkupException;
import org.apache.wicket.markup.MarkupFragment;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.TagUtils;
import org.apache.wicket.markup.html.MarkupUtil;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.panel.BorderMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.resolver.IComponentResolver;
import org.apache.wicket.model.IModel;

/**
 * <p>
 * A {@link AjaxButton} that can also be used as a {@link Border}, with the following limitations:
 * </p>
 * <ul>
 *     <li>Queueing cannot be used for this component.</li>
 *     <li>{@link org.apache.wicket.markup.html.image.resource.LocalizedImageResource LocalizedImageResource} does not
 *     use the correct component as the scope.</li>
 *     <li>There is no additional warning about this border when Wicket detects a component cycle.</li>
 * </ul>
 * <p>
 * The markup for this button must use <code>&lt;wicket:border&gt;</code> (and <code>&lt;wicket:body&gt;</code>) just like
 * <code>Border</code>.
 * </p>
 * <p>
 * The implementation has been copied from <code>Border</code>, and adjusted where needed.
 * </p>
 */
public abstract class AjaxButtonBorder extends AjaxButton implements IComponentResolver, IQueueRegion {
    private final BorderBodyContainer body;

    /**
     * Create instance with label.
     */
    public AjaxButtonBorder(String id, IModel<String> model) {
        super(id, model);

        body = new BorderBodyContainer(this, id + "_" + Border.BODY);
        addToBorder(body);
    }

    public final BorderBodyContainer getBodyContainer() {
        return body;
    }

    @Override
    public AjaxButtonBorder add(final Component... children) {
        for (Component component : children) {
            if (component == body || component.isAuto()) {
                addToBorder(component);
            } else {
                getBodyContainer().add(component);
            }
        }
        return this;
    }

    @Override
    public AjaxButtonBorder addOrReplace(final Component... children) {
        for (Component component : children) {
            if (component == body) {
                // in this case we do not want to redirect to body
                // container but to border's old remove.
                super.addOrReplace(component);
            } else {
                getBodyContainer().addOrReplace(component);
            }
        }
        return this;
    }

    @Override
    public AjaxButtonBorder remove(final Component component) {
        if (component == body) {
            // in this case we do not want to redirect to body
            // container but to border's old remove.
            removeFromBorder(component);
        } else {
            getBodyContainer().remove(component);
        }
        return this;
    }


    @Override
    public AjaxButtonBorder remove(final String id) {
        if (body.getId().equals(id)) {
            // in this case we do not want to redirect to body
            // container but to border's old remove.
            super.remove(id);
        } else {
            getBodyContainer().remove(id);
        }
        return this;
    }

    @Override
    public AjaxButtonBorder removeAll() {
        getBodyContainer().removeAll();
        return this;
    }

    @Override
    public AjaxButtonBorder replace(final Component replacement) {
        if (body.getId().equals(replacement.getId())) {
            // in this case we do not want to redirect to body
            // container but to border's old remove.
            replaceInBorder(replacement);
        } else {
            getBodyContainer().replace(replacement);
        }
        return this;
    }

    public AjaxButtonBorder addToBorder(final Component... children) {
        super.add(children);
        return this;
    }

    @Override
    public AjaxButtonBorder queue(Component... components) {
        throw new IllegalStateException("Do not use queuing with " + getClass().getSimpleName());
    }

    public AjaxButtonBorder removeFromBorder(final Component child) {
        super.remove(child);
        return this;
    }

    public AjaxButtonBorder replaceInBorder(final Component component) {
        super.replace(component);
        return this;
    }

    @Override
    public Component resolve(final MarkupContainer container, final MarkupStream markupStream,
                             final ComponentTag tag) {
        // make sure nested borders are resolved properly
        if (!body.rendering) {
            // We are only interested in border body tags. The tag ID actually is irrelevant since
            // always preset with the same default
            if (TagUtils.isWicketBodyTag(tag)) {
                return body;
            }
        }

        return null;
    }

    @Override
    protected IMarkupSourcingStrategy newMarkupSourcingStrategy() {
        return new BorderMarkupSourcingStrategy();
    }

    @Override
    public IMarkupFragment getMarkup(final Component child) {
        // Border require an associated markup resource file
        IMarkupFragment markup = getAssociatedMarkup();
        if (markup == null) {
            throw new MarkupException("Unable to find associated markup file for ButtonBorder: " + this);
        }

        // Find <wicket:border>
        IMarkupFragment borderMarkup = null;
        for (int i = 0; i < markup.size(); i++) {
            MarkupElement elem = markup.get(i);
            if (TagUtils.isWicketBorderTag(elem)) {
                borderMarkup = new MarkupFragment(markup, i);
                break;
            }
        }

        if (borderMarkup == null) {
            throw new MarkupException(markup.getMarkupResourceStream(),
                "Unable to find <wicket:border> tag in associated markup file for ButtonBorder: " + this);
        }

        // If child == null, return the markup fragment starting with the <wicket:border> tag
        if (child == null) {
            return borderMarkup;
        }

        // Is child == BorderBody?
        if (child == body) {
            // Get the <wicket:body> markup
            return body.getMarkup();
        }

        // Find the markup for the child component
        IMarkupFragment childMarkup = borderMarkup.find(child.getId());
        if (childMarkup != null) {
            return childMarkup;
        }

        return ((BorderMarkupSourcingStrategy) getMarkupSourcingStrategy()).findMarkupInAssociatedFileHeader(
            this, child);
    }

    @Override
    protected DequeueTagAction canDequeueTag(ComponentTag tag) {
        return DequeueTagAction.SKIP;
    }

    @Override
    public Component findComponentToDequeue(ComponentTag tag) {
        throw new IllegalStateException("Do not use queuing with " + getClass().getSimpleName());
    }

    @Override
    protected void addDequeuedComponent(Component component, ComponentTag tag) {
        throw new IllegalStateException("Do not use queuing with " + getClass().getSimpleName());
    }

    @Override
    public IMarkupFragment getRegionMarkup() {
        IMarkupFragment markup = super.getRegionMarkup();

        if (markup == null) {
            return null;
        }

        IMarkupFragment borderMarkup = MarkupUtil.findStartTag(markup, Border.BORDER);

        return borderMarkup != null ? borderMarkup : markup;
    }
}
