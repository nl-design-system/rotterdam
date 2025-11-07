package nl.rotterdam.wicket.docs.dialog;

import nl.rotterdam.nl_design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.nl_design_system.wicket.components.dialog.RdDialogHeadingLevel;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.jspecify.annotations.NonNull;

import static nl.rotterdam.nl_design_system.wicket.components.button.RdButtonAppearance.PRIMARY_ACTION;

public class DialogExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = RdDialogBorder.class;

    public DialogExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static RdDialogBorder exampleModalDialog() {
        return new DialogExamplesPanel.RdDialogBorder("modalDialog", new StringResourceModel("Modal dialog"), RdDialogHeadingLevel.LEVEL_3) {
            @Override
            protected @NonNull Component newFooterContent(String id) {
                var dialogThis = this;
                // The markup provider will be a different component in production code
                var footerContentFragment = new Fragment(id, "dialogButton", this);
                RdAjaxButton button = new RdAjaxButton("button", new StringResourceModel("Button")) {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        dialogThis.close(target);
                    }
                };
                button.setAppearance(PRIMARY_ACTION);
                footerContentFragment.add(button);
                return footerContentFragment;
            }

            @Override
            protected void onClose(@NonNull AjaxRequestTarget target) {
                close(target);
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        var form = new Form<Void>("modalDialogForm");
        add(form);

        var dialog = exampleModalDialog();

        form.add(new RdAjaxButton("show") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                dialog.showModal(target);
            }
        });
        form.add(dialog);
    }

    private abstract static class RdDialogBorder extends nl.rotterdam.nl_design_system.wicket.components.dialog.RdDialogBorder {
        public RdDialogBorder(String id, IModel<?> titleModel, RdDialogHeadingLevel headingLevel) {
            super(id, titleModel, headingLevel);
        }
    }
}
