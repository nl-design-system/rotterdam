package nl.rotterdam.nl_design_system.docs.wicket.table;

import nl.rotterdam.nl_design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.nl_design_system.wicket.components.button.RdButtonHint;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class PersonRowActionsPanel extends GenericPanel<Person> {

    private final Component[] refreshComponents;

    public PersonRowActionsPanel(String id, IModel<Person> model, Component... refreshComponents) {
        super(id, model);
        this.refreshComponents = refreshComponents;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(AttributeModifier.replace("role", "group"));
        add(AttributeModifier.replace("aria-label", getModel().map(m -> "Acties voor " + m.name())));
        add(
            new RdAjaxButton("moveUp", Model.of("⬆")) {

                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveUp");
                    target.add(refreshComponents);
                }
            }.add(AttributeModifier.replace("aria-label", Model.of("Naar boven verplaatsen"))),

            new RdAjaxButton("moveDown", Model.of("⬇")) {
                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveDown");
                    target.add(refreshComponents);
                }
            }.add(AttributeModifier.replace("aria-label", Model.of("Naar beneden verplaatsen"))),

            new RdAjaxButton("edit", Model.of("✏️")) {
                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveDown");
                    target.add(refreshComponents);
                }
            }.add(AttributeModifier.replace("aria-label", Model.of("Wijzigen"))),

            new RdAjaxButton("delete", Model.of("\uD83D\uDDD1")) {
                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveDown");
                    target.add(refreshComponents);
                }

                @Override
                protected void onConfigure() {
                    super.onConfigure();
                    if (PersonRowActionsPanel.this.getModelObject().name().contains("Bakker")) {
                        setEnabled(false);
                        add(AttributeModifier.replace("aria-disabled", "true"));
                        add(AttributeModifier.replace("title", "Verwijderen niet toegestaan, zonder bakkers krijgen we teveel honger"));
                    }
                }

                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    setHint(RdButtonHint.DANGER);
                }
            }.add(AttributeModifier.replace("aria-label", Model.of("Verwijderen")))
        );
    }
}
