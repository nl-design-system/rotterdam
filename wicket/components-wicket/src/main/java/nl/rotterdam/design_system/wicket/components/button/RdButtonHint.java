package nl.rotterdam.design_system.wicket.components.button;

public enum RdButtonHint {
    DANGER("danger"),
    WARNING("warning"),
    READY("ready");

    final String hint;

    RdButtonHint(String hint) {
        this.hint = hint;
    }
}
