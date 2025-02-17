package nl.rotterdam.wicket.docs.sso_login_page;

import nl.rotterdam.design_system.wicket.components.button.utrecht.UtrechtButton;
import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht.UtrechtFormFieldTextbox;
// import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
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
        Model<Boolean> rememberMe = Model.of(true);

        add(
            new Form<Void>("loginForm") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    UtrechtButtonGroupBorder actionGroup = new UtrechtButtonGroupBorder("actionGroup");

                    add(
                        new FeedbackPanel("feedback"),
                        new UtrechtFormFieldTextbox("username", username, "Gebruikersnaam").setRequired(true),
                        new UtrechtFormFieldTextbox("password", password, "Wachtwoord")
                            .setRequired(true)
                            .setInputType("password"),
                        new UtrechtFormFieldCheckbox("rememberMe", rememberMe, "Onthoud mij").setRequired(true),
                        actionGroup
                    );
                    actionGroup.add(new UtrechtButton("submit"));
                }

                @Override
                protected void onError() {
                    super.onError();
                    error("On error called. Only possible in classic browsers who don't support 'required' attribute.");
                }

                @Override
                protected void onSubmit() {
                    super.onSubmit();

                    info("Submitted!");

                    System.out.println("Received username: " + username.getObject());
                    System.out.println("Received rememberMe: " + rememberMe.getObject());
                }
            }
        );
    }
}
