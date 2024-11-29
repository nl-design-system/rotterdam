package nl.rotterdam.wicket.docs.login_form_example;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class LoginFormPanel extends Panel {

    public LoginFormPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Model<String> username = Model.of("");
        Model<String> password = Model.of("");
        Model<Boolean> rememberMe = Model.of(true);

        add(new Form<Void>("loginForm") {

            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(
                    new FeedbackPanel("feedback"),

                    new RequiredTextField<>("username", username)
                        .setLabel(Model.of("Gebruikersnaam")),

                    new PasswordTextField("password", password)
                        .setRequired(true)
                        .setLabel(Model.of("Wachtwoord")),

                    new CheckBox("rememberMe", rememberMe)
                        .setLabel(Model.of("Onthoud mij")),

                    new Button("submit")
                );
            }

            @Override
            protected void onSubmit() {

                info("Submitted!");

                System.out.println("Received username: " + username.getObject());
                System.out.println("Received password: " + password.getObject());
                System.out.println("Received rememberMe: " + rememberMe.getObject());

                super.onSubmit();
            }
        });
    }
}


