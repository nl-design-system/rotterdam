package nl.rotterdam.wicket.docs.sso_login_page;

import nl.rotterdam.wicket.docs.RotterdamBasePage;

public class SingleSignOnLoginPage extends RotterdamBasePage {

    public SingleSignOnLoginPage() {
        super();
        this.pageTitle = "Inloggen";
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        pageBody.add(new SingleSignOnLoginFormPanel("loginForm"));
    }
}
