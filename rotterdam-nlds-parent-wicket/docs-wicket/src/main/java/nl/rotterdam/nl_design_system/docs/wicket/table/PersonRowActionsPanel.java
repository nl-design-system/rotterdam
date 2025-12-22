package nl.rotterdam.nl_design_system.docs.wicket.table;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.icon_button.RdIconAjaxButtonBorder;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
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
            new RdIconAjaxButtonBorder("moveUp", Model.of("Naar boven verplaatsen")) {

                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new WebMarkupContainer("icon")
                        .add(RotterdamIconBehavior.ARROW_UP));

                }

                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveUp");
                    target.add(refreshComponents);
                }
            },

            new RdIconAjaxButtonBorder("moveDown", Model.of("Naar beneden verplaatsen")) {
                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveDown");
                    target.add(refreshComponents);
                }

                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new WebMarkupContainer("icon")
                        .add(RotterdamIconBehavior.ARROW_DOWN));
                }
            },

            new RdIconAjaxButtonBorder("edit", Model.of("Wijzigen")) {

                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(new WebMarkupContainer("icon")
                        .add(RotterdamIconBehavior.EDIT));
                }

                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked moveDown");
                    target.add(refreshComponents);
                }
            },

            new RdIconAjaxButtonBorder("delete", Model.of("Verwijderen")) {
                @Override
                protected void onSubmit(AjaxRequestTarget target) {
                    System.out.println("Clicked delete");
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
                    add(new WebMarkupContainer("icon")
                        .add(RotterdamIconBehavior.TRASH));

//                    setHint(RdButtonHint.DANGER);
                }
            }.add(AttributeModifier.replace("aria-label", Model.of("Verwijderen")))
        );
    }
}
