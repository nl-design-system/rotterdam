package nl.rotterdam.wicket.docs.alert;

import nl.rotterdam.nl_design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.nl_design_system.wicket.components.alert.utrecht.UtrechtAlertType;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.model.Model;

public class AlertExamplesPanel extends ExamplesPanel {
    public AlertExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtAlert.class;
    }

    @ComponentExample
    private static UtrechtAlert exampleAlertError() {
        return new UtrechtAlert(
            "alertError",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            UtrechtAlertType.ERROR
        );
    }

    @ComponentExample
    private static UtrechtAlert exampleAlertWarning() {
        return new UtrechtAlert(
            "alertWarning",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            UtrechtAlertType.WARNING
        );
    }

    @ComponentExample
    private static UtrechtAlert exampleAlertOk() {
        return new UtrechtAlert(
            "alertOk",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            UtrechtAlertType.OK
        );
    }

    @ComponentExample
    private static UtrechtAlert exampleAlertInfo() {
        return new UtrechtAlert(
            "alertInfo",
            Model.of(
                "Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."
            ),
            UtrechtAlertType.INFO
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
