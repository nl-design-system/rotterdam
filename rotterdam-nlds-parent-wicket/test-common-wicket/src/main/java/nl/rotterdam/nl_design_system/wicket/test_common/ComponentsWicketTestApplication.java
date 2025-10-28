package nl.rotterdam.nl_design_system.wicket.test_common;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.DummyHomePage;

public class ComponentsWicketTestApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return DummyHomePage.class;
    }

    @Override
    public void init() {
        super.init();

        // Avoid <wicket:panel> in the output HTML
        getMarkupSettings().setStripWicketTags(true);
    }
}
