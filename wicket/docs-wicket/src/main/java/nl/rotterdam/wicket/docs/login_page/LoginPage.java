package nl.rotterdam.wicket.docs.login_page;

import nl.rotterdam.wicket.docs.login_form_example.LoginFormPanel;
import org.apache.wicket.markup.html.WebPage;

public class LoginPage extends WebPage {
    public LoginPage() {
        super();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new LoginFormPanel("loginForm"));
    }
}
