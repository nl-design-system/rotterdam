package nl.rotterdam.wicket.docs.alert;

import nl.rotterdam.nl_design_system.wicket.components.alert.RdAlert;
import nl.rotterdam.nl_design_system.wicket.components.alert.RdAlertType;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.model.Model;

public class AlertExamplesPanel extends ExamplesPanel {
    public AlertExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdAlert.class;
    }

    @ComponentExample
    private static RdAlert exampleAlertError() {
        return new RdAlert(
            "alertError",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            RdAlertType.ERROR
        );
    }

    @ComponentExample
    private static RdAlert exampleAlertWarning() {
        return new RdAlert(
            "alertWarning",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            RdAlertType.WARNING
        );
    }

    @ComponentExample
    private static RdAlert exampleAlertOk() {
        return new RdAlert(
            "alertOk",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            RdAlertType.OK
        );
    }

    @ComponentExample
    private static RdAlert exampleAlertInfo() {
        return new RdAlert(
            "alertInfo",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            RdAlertType.INFO
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleAlertError());
        add(exampleAlertWarning());
        add(exampleAlertOk());
        add(exampleAlertInfo());
    }
}
