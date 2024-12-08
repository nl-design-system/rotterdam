package nl.rotterdam.design_system.wicket.components.button.utrecht;

public enum UtrechtButtonHint {
    DANGER("danger"),
    WARNING("warning"),
    READY("ready");

    final String hint;

    UtrechtButtonHint(String hint) {
        this.hint = hint;
    }
}
