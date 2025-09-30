package nl.rotterdam.wicket.docs.sso_login_page;

import nl.rotterdam.design_system.wicket.components.button.NlButton;
import nl.rotterdam.design_system.wicket.components.button_group.utrecht.UtrechtButtonGroupBorder;
import nl.rotterdam.design_system.wicket.components.form_field_checkbox.NlFormFieldCheckbox;
import nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht.UtrechtFormFieldTextbox;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import java.time.LocalTime;

public class SingleSignOnLoginFormPanel extends Panel {


   private final Model<String> sampleMinLength8 = Model.of("min 8");
   private final Model<String> username = Model.of("");
   private final Model<String> password = Model.of("");
   private final Model<Boolean> rememberMe = Model.of(true);

    public SingleSignOnLoginFormPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            new Form<Void>("loginForm") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(
                        new FeedbackPanel("feedback"),
                        new UtrechtFormFieldTextbox<>("username", username, Model.of("Gebruikersnaam"))
                            .setRequired(true),
                        new UtrechtFormFieldTextbox<>("password", password, Model.of("Wachtwoord"))
                            .setRequired(true)
                            .setInputType("password"),
                        new NlFormFieldCheckbox("rememberMe", rememberMe, Model.of("Onthoud mij"))
                            .setRequired(true),
                        newMinLength8(sampleMinLength8),
                        new UtrechtButtonGroupBorder("actionGroup")
                            .add(new NlButton("submit"))
                    );
                }

                @Override
                protected void onError() {
                    super.onError();
                    error("On error called. Only possible in classic browsers who don't support 'required' attribute.");
                }

                @Override
                protected void onSubmit() {
                    super.onSubmit();

                    info("Submitted for user: " + username.getObject() + " at time: " + LocalTime.now());

                    System.out.println("Received username: " + username.getObject());
                    System.out.println("Received rememberMe: " + rememberMe.getObject());
                }
                private Component newMinLength8(Model<String> sampleMinLength8) {
                    UtrechtFormFieldTextbox<String> textbox = new UtrechtFormFieldTextbox<>("minLength8", sampleMinLength8, Model.of("Minimale lengte 8 tekens"))
                        .setRequired(true);

                    textbox.getTextField().add(StringValidator.minimumLength(8));

                    return textbox;
                }
            }

        );
    }


}
