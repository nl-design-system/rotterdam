package nl.rotterdam.design_system.wicket.components.test_common;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.HTML5Attributes;
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

        // A listener to instantiations of FormComponents to add HTML5 attributes.
        getComponentInstantiationListeners().add(new HTML5Attributes.InstantiationListener());


    }

}
