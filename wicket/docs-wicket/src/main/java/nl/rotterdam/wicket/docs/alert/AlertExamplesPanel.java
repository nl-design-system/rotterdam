package nl.rotterdam.wicket.docs.alert;

import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlert;
import nl.rotterdam.design_system.wicket.components.alert.utrecht.UtrechtAlertType;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class AlertExamplesPanel extends Panel {

    public AlertExamplesPanel(String id) {
        super(id);
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
