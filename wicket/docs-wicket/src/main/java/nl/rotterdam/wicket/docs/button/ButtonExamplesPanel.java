package nl.rotterdam.wicket.docs.button;

import nl.rotterdam.design_system.wicket.components.button.RdButton;
import nl.rotterdam.design_system.wicket.components.button.RdButtonAppearance;
import nl.rotterdam.design_system.wicket.components.button.RdButtonHint;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class ButtonExamplesPanel extends Panel {

    public ButtonExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component nlButton() {
        return new RdButton("nlButton");
    }

    @ComponentExample
    private static Component nlButtonDisabled() {
        RdButton button = new RdButton("nlButtonDisabled");
        button.setEnabled(false);
        return button;
    }

    @ComponentExample
    private static Component nlButtonBusy() {
        RdButton button = new RdButton("nlButtonBusy");
        button.setBusy(true);
        return button;
    }

    @ComponentExample
    private static Component nlButtonToggle() {
        RdButton button = new RdButton("nlButtonToggle");
        button.setPressed(false);
        return button;
    }

    @ComponentExample
    private static Component nlButtonPressed() {
        RdButton button = new RdButton("nlButtonPressed");
        button.setPressed(true);
        return button;
    }

    @ComponentExample
    private static Component nlButtonIconStart() {
        RdButton button = new RdButton("nlButtonIconStart");
        return button;
    }

    @ComponentExample
    private static Component nlButtonPrimaryAction() {
        RdButton button = new RdButton("nlButtonPrimaryAction");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSecondaryAction() {
        RdButton button = new RdButton("nlButtonSecondaryAction");
        button.setAppearance(RdButtonAppearance.SECONDARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSubtle() {
        RdButton button = new RdButton("nlButtonSubtle");
        button.setAppearance(RdButtonAppearance.SUBTLE);
        return button;
    }

    @ComponentExample
    private static Component nlButtonPrimaryActionDanger() {
        RdButton button = new RdButton("nlButtonPrimaryActionDanger");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        button.setHint(RdButtonHint.DANGER);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSubmit() {
        RdButton button = new RdButton("nlButtonSubmit") {
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

        add(nlButton());
        add(nlButtonDisabled());
        add(nlButtonBusy());
        add(nlButtonToggle());
        add(nlButtonPressed());
        add(nlButtonIconStart());
        add(nlButtonPrimaryAction());
        add(nlButtonSecondaryAction());
        add(nlButtonSubtle());
        add(nlButtonPrimaryActionDanger());
        add(nlButtonSubmit());
    }
}
