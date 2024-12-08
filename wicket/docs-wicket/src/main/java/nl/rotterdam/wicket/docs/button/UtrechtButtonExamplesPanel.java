package nl.rotterdam.wicket.docs.button;

import nl.rotterdam.design_system.wicket.components.button.utrecht.UtrechtButton;
import nl.rotterdam.design_system.wicket.components.button.utrecht.UtrechtButtonAppearance;
import nl.rotterdam.design_system.wicket.components.button.utrecht.UtrechtButtonHint;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtButtonExamplesPanel extends Panel {

    public UtrechtButtonExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component utrechtButton() {
        return new UtrechtButton("utrechtButton");
    }

    @ComponentExample
    private static Component utrechtButtonDisabled() {
        UtrechtButton button = new UtrechtButton("utrechtButtonDisabled");
        button.setEnabled(false);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonBusy() {
        UtrechtButton button = new UtrechtButton("utrechtButtonBusy");
        button.setBusy(true);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonToggle() {
        UtrechtButton button = new UtrechtButton("utrechtButtonToggle");
        button.setPressed(false);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonPressed() {
        UtrechtButton button = new UtrechtButton("utrechtButtonPressed");
        button.setPressed(true);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonIconStart() {
        UtrechtButton button = new UtrechtButton("utrechtButtonIconStart");
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonPrimaryAction() {
        UtrechtButton button = new UtrechtButton("utrechtButtonPrimaryAction");
        button.setAppearance(UtrechtButtonAppearance.PRIMARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonSecondaryAction() {
        UtrechtButton button = new UtrechtButton("utrechtButtonSecondaryAction");
        button.setAppearance(UtrechtButtonAppearance.SECONDARY_ACTION);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonSubtle() {
        UtrechtButton button = new UtrechtButton("utrechtButtonSubtle");
        button.setAppearance(UtrechtButtonAppearance.SUBTLE);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonPrimaryActionDanger() {
        UtrechtButton button = new UtrechtButton("utrechtButtonPrimaryActionDanger");
        button.setAppearance(UtrechtButtonAppearance.PRIMARY_ACTION);
        button.setHint(UtrechtButtonHint.DANGER);
        return button;
    }

    @ComponentExample
    private static Component utrechtButtonSubmit() {
        UtrechtButton button = new UtrechtButton("utrechtButtonSubmit") {
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

        add(utrechtButton());
        add(utrechtButtonDisabled());
        add(utrechtButtonBusy());
        add(utrechtButtonToggle());
        add(utrechtButtonPressed());
        add(utrechtButtonIconStart());
        add(utrechtButtonPrimaryAction());
        add(utrechtButtonSecondaryAction());
        add(utrechtButtonSubtle());
        add(utrechtButtonPrimaryActionDanger());
        add(utrechtButtonSubmit());
    }
}
