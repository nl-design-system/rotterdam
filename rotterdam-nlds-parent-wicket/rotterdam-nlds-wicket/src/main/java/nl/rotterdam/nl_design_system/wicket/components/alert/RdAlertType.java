package nl.rotterdam.nl_design_system.wicket.components.alert;

public enum RdAlertType {
    OK("ok"),
    WARNING("warning"),
    ERROR("error"),
    INFO("info");

    final String type;

    RdAlertType(String type) {
        this.type = type;
    }
}
