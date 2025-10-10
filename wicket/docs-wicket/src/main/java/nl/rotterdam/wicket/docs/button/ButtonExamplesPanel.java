package nl.rotterdam.wicket.docs.button;

import nl.rotterdam.design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.design_system.wicket.components.button.RdButton;
import nl.rotterdam.design_system.wicket.components.button.RdButtonAppearance;
import nl.rotterdam.design_system.wicket.components.button.RdButtonHint;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class ButtonExamplesPanel extends Panel {

    public ButtonExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component button() {
        return new RdButton("button");
    }

    @ComponentExample
    private static Component formAndAjaxButton() {
        return new Form<Void>("formOfAjaxButton") {

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
    private static Component buttonDisabled() {
        RdButton button = new RdButton("buttonDisabled");
        button.setEnabled(false);
        return button;
    }

    @ComponentExample
    private static Component buttonBusy() {
        RdButton button = new RdButton("buttonBusy");
        button.setBusy(true);
        return button;
    }

    @ComponentExample
    private static Component buttonToggle() {
        RdButton button = new RdButton("buttonToggle");
        button.setPressed(false);
        return button;
    }

    @ComponentExample
    private static Component buttonPressed() {
        RdButton button = new RdButton("buttonPressed");
        button.setPressed(true);
        return button;
    }

    @ComponentExample
    private static Component buttonIconStart() {
        RdButton button = new RdButton("buttonIconStart");
        return button;
    }

    @ComponentExample
    private static Component buttonPrimaryAction() {
        RdButton button = new RdButton("buttonPrimaryAction");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component buttonSecondaryAction() {
        RdButton button = new RdButton("buttonSecondaryAction");
        button.setAppearance(RdButtonAppearance.SECONDARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component buttonSubtle() {
        RdButton button = new RdButton("buttonSubtle");
        button.setAppearance(RdButtonAppearance.SUBTLE);
        return button;
    }

    @ComponentExample
    private static Component buttonPrimaryActionDanger() {
        RdButton button = new RdButton("buttonPrimaryActionDanger");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        button.setHint(RdButtonHint.DANGER);
        return button;
    }

    @ComponentExample
    private static Component buttonSubmit() {
        RdButton button = new RdButton("buttonSubmit") {
            // @Override
            // protected void onSubmit() {
            //     info("Submitted!");
            //     super.onSubmit();
            // }
        };
        // TODO: Find out how this works
        return button;
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
