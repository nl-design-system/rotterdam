package nl.rotterdam.nl_design_system.wicket.components.alert.utrecht;

public enum UtrechtAlertType {
    OK("ok"),
    WARNING("warning"),
    ERROR("error"),
    INFO("info");

    final String type;

    UtrechtAlertType(String type) {
        this.type = type;
    }
}
