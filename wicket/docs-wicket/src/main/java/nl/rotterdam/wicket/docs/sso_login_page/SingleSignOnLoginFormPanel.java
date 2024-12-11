package nl.rotterdam.wicket.docs.sso_login_page;

import nl.rotterdam.design_system.wicket.components.button.utrecht.UtrechtButton;
import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class SingleSignOnLoginFormPanel extends Panel {

    public SingleSignOnLoginFormPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Model<String> username = Model.of("");
        Model<String> password = Model.of("");
        Model<Boolean> rememberMe = Model.of(false);

        add(
            new Form<Void>("loginForm") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    UtrechtButtonGroupBorder actionGroup = new UtrechtButtonGroupBorder("actionGroup");

                    add(
                        new FeedbackPanel("feedback"),
                        new RequiredTextField<>("username", username)
                            .setRequired(true)
                            .setLabel(Model.of("Gebruikersnaam")),
                        new PasswordTextField("password", password).setRequired(true).setLabel(Model.of("Wachtwoord")),
                        new CheckBox("rememberMe", rememberMe).setLabel(Model.of("Onthoud mij")),
                        new UtrechtFormFieldCheckbox("rememberMeNlDesign", rememberMe, "Onthoud mij").setRequired(true),
                        actionGroup
                    );
                    actionGroup.add(new UtrechtButton("submit"));
                }

                @Override
                protected void onSubmit() {
                    info("Submitted!");

                    System.out.println("Received username: " + username.getObject());
                    System.out.println("Received rememberMe: " + rememberMe.getObject());

                    super.onSubmit();
                }
            }
        );
    }
}
