package nl.rotterdam.wicket.docs.button;

import nl.rotterdam.design_system.wicket.components.button.NlButton;
import nl.rotterdam.design_system.wicket.components.button.NlButtonAppearance;
import nl.rotterdam.design_system.wicket.components.button.NlButtonHint;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class NlButtonExamplesPanel extends Panel {

    public NlButtonExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component nlButton() {
        return new NlButton("nlButton");
    }

    @ComponentExample
    private static Component nlButtonDisabled() {
        NlButton button = new NlButton("nlButtonDisabled");
        button.setEnabled(false);
        return button;
    }

    @ComponentExample
    private static Component nlButtonBusy() {
        NlButton button = new NlButton("nlButtonBusy");
        button.setBusy(true);
        return button;
    }

    @ComponentExample
    private static Component nlButtonToggle() {
        NlButton button = new NlButton("nlButtonToggle");
        button.setPressed(false);
        return button;
    }

    @ComponentExample
    private static Component nlButtonPressed() {
        NlButton button = new NlButton("nlButtonPressed");
        button.setPressed(true);
        return button;
    }

    @ComponentExample
    private static Component nlButtonIconStart() {
        NlButton button = new NlButton("nlButtonIconStart");
        return button;
    }

    @ComponentExample
    private static Component nlButtonPrimaryAction() {
        NlButton button = new NlButton("nlButtonPrimaryAction");
        button.setAppearance(NlButtonAppearance.PRIMARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSecondaryAction() {
        NlButton button = new NlButton("nlButtonSecondaryAction");
        button.setAppearance(NlButtonAppearance.SECONDARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSubtle() {
        NlButton button = new NlButton("nlButtonSubtle");
        button.setAppearance(NlButtonAppearance.SUBTLE);
        return button;
    }

    @ComponentExample
    private static Component nlButtonPrimaryActionDanger() {
        NlButton button = new NlButton("nlButtonPrimaryActionDanger");
        button.setAppearance(NlButtonAppearance.PRIMARY_ACTION);
        button.setHint(NlButtonHint.DANGER);
        return button;
    }

    @ComponentExample
    private static Component nlButtonSubmit() {
        NlButton button = new NlButton("nlButtonSubmit") {
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
