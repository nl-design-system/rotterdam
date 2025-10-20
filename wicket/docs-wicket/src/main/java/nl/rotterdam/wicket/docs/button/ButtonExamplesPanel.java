package nl.rotterdam.wicket.docs.button;

import nl.rotterdam.design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.design_system.wicket.components.button.RdButton;
import nl.rotterdam.design_system.wicket.components.button.RdButtonAppearance;
import nl.rotterdam.design_system.wicket.components.button.RdButtonHint;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class ButtonExamplesPanel extends Panel {

    public ButtonExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static RdButton button() {
        return new RdButton("button");
    }

    @ComponentExample
    private static Form<Void> formAndAjaxButton() {
        return new Form<>("formOfAjaxButton") {

            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(new RdAjaxButton("ajaxButton") {

                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        System.out.println("ajaxButton submitted");
                    }
                });
            }
        };
    }

    @ComponentExample
    private static RdButton buttonDisabled() {
        RdButton component = new RdButton("buttonDisabled");
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdButton buttonBusy() {
        RdButton component = new RdButton("buttonBusy");
        component.setBusy(true);
        return component;
    }

    @ComponentExample
    private static RdButton buttonToggle() {
        RdButton component = new RdButton("buttonToggle");
        component.setPressed(false);
        return component;
    }

    @ComponentExample
    private static RdButton buttonPressed() {
        RdButton component = new RdButton("buttonPressed");
        component.setPressed(true);
        return component;
    }

    @ComponentExample
    private static RdButton buttonIconStart() {
        return new RdButton("buttonIconStart");
    }

    @ComponentExample
    private static RdButton buttonPrimaryAction() {
        RdButton component = new RdButton("buttonPrimaryAction");
        component.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        return component;
    }

    @ComponentExample
    private static RdButton buttonSecondaryAction() {
        RdButton component = new RdButton("buttonSecondaryAction");
        component.setAppearance(RdButtonAppearance.SECONDARY_ACTION);
        return component;
    }

    @ComponentExample
    private static RdButton buttonSubtle() {
        RdButton component = new RdButton("buttonSubtle");
        component.setAppearance(RdButtonAppearance.SUBTLE);
        return component;
    }

    @ComponentExample
    private static RdButton buttonPrimaryActionDanger() {
        RdButton component = new RdButton("buttonPrimaryActionDanger");
        component.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        component.setHint(RdButtonHint.DANGER);
        return component;
    }

    @ComponentExample
    private static RdButton buttonSubmit() {
        RdButton component = new RdButton("buttonSubmit") {
            // @Override
            // protected void onSubmit() {
            //     info("Submitted!");
            //     super.onSubmit();
            // }
        };
        // TODO: Find out how this works
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(button());
        add(formAndAjaxButton());
        add(buttonDisabled());
        add(buttonBusy());
        add(buttonToggle());
        add(buttonPressed());
        add(buttonIconStart());
        add(buttonPrimaryAction());
        add(buttonSecondaryAction());
        add(buttonSubtle());
        add(buttonPrimaryActionDanger());
        add(buttonSubmit());
    }
}
