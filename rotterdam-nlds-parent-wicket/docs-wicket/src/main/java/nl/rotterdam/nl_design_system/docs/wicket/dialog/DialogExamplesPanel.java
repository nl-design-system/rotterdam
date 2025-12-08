package nl.rotterdam.nl_design_system.docs.wicket.dialog;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.action_group.RdActionGroup;
import nl.rotterdam.nl_design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.nl_design_system.wicket.components.dialog.RdDialogHeadingLevel;
import nl.rotterdam.nl_design_system.wicket.html.TemplateInstance;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import static nl.rotterdam.nl_design_system.wicket.components.button.RdButtonAppearance.PRIMARY_ACTION;

public class DialogExamplesPanel extends ExamplesPanel {
    public DialogExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdDialogBorder.class;
    }

    @ComponentExample
    private static WebMarkupContainer exampleDialog() {
        var parent = new WebMarkupContainer("dialog");
        
        TemplateInstance.add(parent, "dialog", (id, fragmentContainer) ->
            new DialogExamplesPanel.RdDialogBorder(id, new StringResourceModel("Dialog"), RdDialogHeadingLevel.LEVEL_3) {
                @Override
                protected Component newFooterContent(String id) {
                    var footerContentFragment = new Fragment(id, "footer", fragmentContainer);
                    RdAjaxButton button = new RdAjaxButton("button", new StringResourceModel("Button")) {
                        @Override
                        protected void onSubmit(AjaxRequestTarget target) {
                            close(target);
                        }
                    };
                    button.setAppearance(PRIMARY_ACTION);
                    footerContentFragment.add(button);
                    return footerContentFragment;
                }

                @Override
                protected void onClose(AjaxRequestTarget target) {
                    close(target);
                }
            });
        
        return parent;
    }

    @ComponentExample
    private static WebMarkupContainer exampleModalDialog() {
        var parent = new WebMarkupContainer("modalDialog");
        
        TemplateInstance.add(parent, "modalDialog", (id, fragmentContainer) ->
            new DialogExamplesPanel.RdDialogBorder(id, new StringResourceModel("Modal dialog"), RdDialogHeadingLevel.LEVEL_3) {
                @Override
                protected Component newFooterContent(String id) {
                    // The markup provider will be a different component in production code
                    var footerContentFragment = new Fragment(id, "footer", fragmentContainer);
                    RdAjaxButton button = new RdAjaxButton("button", new StringResourceModel("Button")) {
                        @Override
                        protected void onSubmit(AjaxRequestTarget target) {
                            close(target);
                        }
                    };
                    button.setAppearance(PRIMARY_ACTION);
                    footerContentFragment.add(button);
                    return footerContentFragment;
                }

                @Override
                protected void onClose(AjaxRequestTarget target) {
                    close(target);
                }
            });
        
        return parent;
    }

    @ComponentExample
    private static WebMarkupContainer exampleConfirmDeleteDialog() {
        var parent = new WebMarkupContainer("confirmDeleteDialog");
        
        TemplateInstance.add(parent, "confirmDeleteDialog", (id, fragmentContainer) ->
            new RdDialogBorder(id, Model.of("Afspraak verwijderen"), RdDialogHeadingLevel.LEVEL_1) {
                @Override
                protected Component newFooterContent(String id) {
                    var fragment = new Fragment(id, "footer", fragmentContainer);
                    var radioGroup = new RdActionGroup("buttonGroup") {
                        @Override
                        protected void onInitialize() {
                            super.onInitialize();
                            add(
                                new RdAjaxButton("confirm") {
                                    @Override
                                    protected void onSubmit(AjaxRequestTarget target) {
                                        close(target);
                                    }
                                },
                                new RdAjaxButton("cancel") {
                                    @Override
                                    protected void onSubmit(AjaxRequestTarget target) {
                                        close(target);
                                    }
                                }
                            );
                        }
                    };
                    fragment.add(radioGroup);
                    return fragment;
                }

                @Override
                protected void onClose(AjaxRequestTarget target) {
                    close(target);
                }
            });
        
        return parent;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addDialogSection();
        addModalDialogSection();
        addConfirmDeleteDialogSection();
    }

    private void addDialogSection() {
        var dialogForm = new Form<Void>("dialogForm");
        add(dialogForm);

        var dialogParent = exampleDialog();
        dialogForm.add(dialogParent);
        var dialog = (RdDialogBorder) dialogParent.get("dialog");

        dialogForm.add(new RdAjaxButton("show") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                dialog.show(target);
            }
        });
    }

    private void addModalDialogSection() {
        var modalDialogForm = new Form<Void>("modalDialogForm");
        add(modalDialogForm);

        var modalDialogParent = exampleModalDialog();
        modalDialogForm.add(modalDialogParent);
        var modalDialog = (RdDialogBorder) modalDialogParent.get("modalDialog");

        modalDialogForm.add(new RdAjaxButton("showModal") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                modalDialog.showModal(target);
            }
        });
    }

    private void addConfirmDeleteDialogSection() {
        var modalDialogForm = new Form<Void>("confirmDeleteDialogForm");
        add(modalDialogForm);

        var dialogParent = exampleConfirmDeleteDialog();
        modalDialogForm.add(dialogParent);
        var confirmDeleteDialog = (RdDialogBorder) dialogParent.get("confirmDeleteDialog");

        modalDialogForm.add(new RdAjaxButton("showModal") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                confirmDeleteDialog.showModal(target);
            }
        });
    }

    private abstract static class RdDialogBorder extends nl.rotterdam.nl_design_system.wicket.components.dialog.RdDialogBorder {
        public RdDialogBorder(String id, IModel<?> titleModel, RdDialogHeadingLevel headingLevel) {
            super(id, titleModel, () -> new RotterdamIconBehavior(RotterdamIconType.CLOSE), headingLevel);
        }
    }
}
