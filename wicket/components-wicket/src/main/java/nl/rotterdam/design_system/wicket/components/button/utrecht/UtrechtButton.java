package nl.rotterdam.design_system.wicket.components.button.utrecht;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;

public class UtrechtButton extends Button {

    public boolean busy = false;
    public UtrechtButtonAppearance appearance = null;
    public UtrechtButtonHint hint = null;
    public boolean pressed = false;

    public UtrechtButton(String id) {
        this(id, null);
    }

    public UtrechtButton(final String id, final IModel<String> model) {
        super(id, model);
    }

    public void setAppearance(UtrechtButtonAppearance appearance) {
        this.appearance = appearance;
    }

    public void setHint(UtrechtButtonHint hint) {
        this.hint = hint;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        boolean isEnabled = this.isEnabled();
        boolean isBusy = this.busy;
        UtrechtButtonAppearance appearance = this.appearance;
        UtrechtButtonHint hint = this.hint;
        boolean isPressed = this.pressed;

        add(
            new UtrechtButtonBehavior() {
                @Override
                public String[] getClassNames() {
                    return new String[] {
                        "utrecht-button",
                        appearance != null ? "utrecht-button--" + appearance.appearance : "",
                        hint != null ? "utrecht-button--" + hint.hint : "",
                        isEnabled ? "" : "utrecht-button--disabled",
                        isPressed ? "utrecht-button--pressed" : "",
                        isBusy ? "utrecht-button--busy" : "",
                    };
                }
            }
        );
    }
}
