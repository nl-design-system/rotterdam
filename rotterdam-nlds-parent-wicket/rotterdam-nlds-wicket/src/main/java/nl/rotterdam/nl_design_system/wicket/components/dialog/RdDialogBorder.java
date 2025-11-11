package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.heading.RdHeading;
import nl.rotterdam.nl_design_system.wicket.components.icon.RdIconBorder;
import nl.rotterdam.nl_design_system.wicket.components.icon_button.RdIconAjaxButtonBorder;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.jspecify.annotations.NonNull;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.AMSTERDAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/dialog/">dialog</a> to inform the user or ask for input, which also supports
 * blocking interaction with other elements of the page (
 * <a href="https://nldesignsystem.nl/modal-dialog/">modal dialog</a>). It must be used with a
 * <code>&lt;dialog&gt;</code> element.
 * </p>
 * <p>
 * <strong>WARNING</strong>: do not use <code>setVisible(...)</code> to show or hide the dialog. Use
 * {@link #show(AjaxRequestTarget)}, {@link #showModal(AjaxRequestTarget)} and {@link #close(AjaxRequestTarget)}
 * instead. These methods will use the correct JavaScript functions to manage the visibility of the dialog.
 * </p>
 * <p>
 * This implementation is based on the
 * <a href="https://designsystem.amsterdam/?path=/docs/components-containers-dialog--docs">implementation of Amsterdam</a>.
 * <code>ModalDialog</code> of Wicket Extensions is not used as it uses the wrong markup.
 * </p>
 *
 * @see RdDialogHeadingLevel
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = AMSTERDAM)
public abstract class RdDialogBorder extends Border {

    private static final String FOOTER_CONTENT_ID = "footerContent";

    @NonNull
    private final Supplier<Behavior> closeIconBehaviorSupplier;

    @NonNull
    private final IModel<String> closeButtonLabelModel;

    @NonNull
    private final WebMarkupContainer content;

    @NonNull
    private final Component heading;

    @NonNull
    private final Component closeButton;

    /**
     * <p>
     * Create a new dialog border with the given Wicket ID, title model and heading level.
     * </p>
     *
     * @param id the wicket ID.
     * @param titleModel the model with the title to show in the dialog header.
     * @param closeIconBehaviorSupplier the supplier of the behavior that will configure the icon tag.
     * @param headingLevel the level of the heading in the dialog header. This affects the title heading element and the
     *                     icon button.
     */
    public RdDialogBorder(@NonNull String id,
                          @NonNull IModel<?> titleModel,
                          @NonNull Supplier<Behavior> closeIconBehaviorSupplier,
                          @NonNull RdDialogHeadingLevel headingLevel) {
        super(id, requireNonNull(titleModel));

        this.closeIconBehaviorSupplier = requireNonNull(closeIconBehaviorSupplier);
        closeButtonLabelModel = new StringResourceModel("Close", this);

        setOutputMarkupId(true);

        content = newContent();
        heading = newHeading(headingLevel);
        closeButton = newCloseButton();
    }

    /**
     * <p>
     * Create a new dialog border with the given Wicket ID, title model, close button label model and heading level.
     * </p>
     *
     * @param id the wicket ID.
     * @param titleModel the model with the title to show in the dialog header.
     * @param closeIconBehaviorSupplier the supplier of the behavior that will configure the icon tag.
     * @param closeButtonLabelModel the model with the label for the close button.
     * @param headingLevel the level of the heading in the dialog header. This affects the title heading element and the
     *                     icon button.
     */
    public RdDialogBorder(@NonNull String id,
                          @NonNull IModel<?> titleModel,
                          @NonNull Supplier<Behavior> closeIconBehaviorSupplier,
                          @NonNull IModel<String> closeButtonLabelModel,
                          @NonNull RdDialogHeadingLevel headingLevel) {
        super(id, requireNonNull(titleModel));

        this.closeIconBehaviorSupplier = requireNonNull(closeIconBehaviorSupplier);
        this.closeButtonLabelModel = requireNonNull(closeButtonLabelModel);

        setOutputMarkupId(true);

        content = newContent();
        heading = newHeading(headingLevel);
        closeButton = newCloseButton();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdDialogBehavior.INSTANCE);

        addToBorder(content);
        content.add(
            heading,
            closeButton,
            newFooterContent(FOOTER_CONTENT_ID)
        );
    }

    /**
     * <p>
     * Get the component for the heading element (<code>&lt;h1&gt;</code>-<code>&lt;h6&gt;</code>).
     * </p>
     *
     * @return the heading Wicket component.
     */
    public @NonNull Component getHeadingComponent() {
        return heading;
    }

    /**
     * <p>
     * Get the component for the <code>&lt;button&gt;</code> element of the close button.
     * </p>
     *
     * @return the close button Wicket component.
     */
    public @NonNull Component getCloseButtonComponent() {
        return closeButton;
    }

    /**
     * <p>
     * Create the footer content component. The element is a <code>div</code>.
     * </p>
     *
     * @param id the Wicket ID for the footer content component.
     * @return the footer content component.
     */
    @NonNull
    protected abstract Component newFooterContent(String id);

    /**
     * <p>
     * Called when the user clicks the close button.
     * </p>
     *
     * @param target the Ajax request target.
     */
    protected abstract void onClose(@NonNull AjaxRequestTarget target);

    /**
     * <p>
     * Make the dialog visible in a non-modal way. Invokes JavaScript function <code>show()</code> on the dialog
     * element.
     * </p>
     *
     * @param target the Ajax request target.
     */
    public void show(@NonNull AjaxRequestTarget target) {
        content.setVisible(true);
        target.add(content);
        target.appendJavaScript("document.getElementById('" + getMarkupId() + "').show();");
    }

    /**
     * <p>
     * Make the dialog visible in a modal way. Invokes JavaScript function <code>showModal()</code> on the dialog
     * element.
     * </p>
     *
     * @param target the Ajax request target.
     */
    public void showModal(@NonNull AjaxRequestTarget target) {
        content.setVisible(true);
        target.add(content);
        target.appendJavaScript("document.getElementById('" + getMarkupId() + "').showModal();");
    }

    /**
     * <p>
     * Close the dialog. Invokes JavaScript function <code>close()</code> on the dialog element.
     * </p>
     *
     * @param target the Ajax request target.
     */
    public void close(@NonNull AjaxRequestTarget target) {
        content.setVisible(false);
        target.add(content);
        target.appendJavaScript("document.getElementById('" + getMarkupId() + "').close();");
    }

    private @NonNull WebMarkupContainer newContent() {
        var content = new WebMarkupContainer("content");
        content.setOutputMarkupPlaceholderTag(true);
        // Dialog content only needs to be visible if it is shown.
        content.setVisible(false);
        return content;
    }

    private @NonNull Component newHeading(RdDialogHeadingLevel headingLevel) {
        return new RdHeading("title", getDefaultModel(), headingLevel.getLevel());
    }

    private @NonNull Component newCloseButton() {
        var closeButton = new RdIconAjaxButtonBorder("closeButton", closeButtonLabelModel) {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                onClose(target);
            }
        };

        var icon = new RdIconBorder("icon");

        var closeSymbol = new WebMarkupContainer("close");
        closeSymbol.add(closeIconBehaviorSupplier.get());

        closeButton.add(
            icon.add(closeSymbol)
        );

        return closeButton;
    }
}
