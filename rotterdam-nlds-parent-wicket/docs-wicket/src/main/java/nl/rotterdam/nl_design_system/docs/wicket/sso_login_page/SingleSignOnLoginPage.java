package nl.rotterdam.nl_design_system.docs.wicket.sso_login_page;

import nl.rotterdam.nl_design_system.docs.wicket.RotterdamBasePage;

public class SingleSignOnLoginPage extends RotterdamBasePage {

    public SingleSignOnLoginPage() {
        super("Inloggen");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        pageBody.add(new SingleSignOnLoginFormPanel("loginForm"));
    }
}
