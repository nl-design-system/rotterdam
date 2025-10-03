package nl.rotterdam.design_system.wicket.components.button;

public enum NlButtonHint {
    DANGER("danger"),
    WARNING("warning"),
    READY("ready");

    final String hint;

    NlButtonHint(String hint) {
        this.hint = hint;
    }
}
