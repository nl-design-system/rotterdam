package nl.rotterdam.wicket.docs;

import nl.rotterdam.wicket.docs.mijn_loket_page.MijnLoketPage;
import nl.rotterdam.wicket.docs.sso_login_page.SingleSignOnLoginPage;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.ExceptionSettings;

public class DocsApplication extends WebApplication {

    @Override
    public void init() {
        super.init();

        // Avoid <wicket:panel> in the output HTML
        getMarkupSettings().setStripWicketTags(true);

        // A listener to instantiations of FormComponents to add HTML5 attributes.
        getComponentInstantiationListeners().add(new HTML5Attributes.InstantiationListener());

        // Configure our own fance error page
        getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_EXCEPTION_PAGE);

        /*
         * `CSPDirective` does not appear to support every option we want.
         *
         * TODO: Implement the following CSP directives:
         *
         *   - `.add("block-all-mixed-content")`
         *   - `.add("worker-src", "blob")`
         *   - `.add("form-action", CSPDirectiveSrcValue.SELF)`
         */
        getCspSettings()
            .blocking()
            .clear()
            .add(CSPDirective.DEFAULT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.OBJECT_SRC, CSPDirectiveSrcValue.NONE)
            .add(CSPDirective.BASE_URI, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.FRAME_ANCESTORS, CSPDirectiveSrcValue.NONE)
            .add(CSPDirective.CONNECT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.CONNECT_SRC, "blob:")
            .add(CSPDirective.CONNECT_SRC, "data:")
            .add(CSPDirective.IMG_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.IMG_SRC, "blob:")
            .add(CSPDirective.IMG_SRC, "data:")
            .add(CSPDirective.FONT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.UNSAFE_INLINE)
            .add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF);
        mountPage("sso", SingleSignOnLoginPage.class);
        mountPage("rotterdam-base-page", RotterdamBasePage.class);
        mountPage("hello-world", RotterdamHelloWorldPage.class);
        mountPage("mijn-loket", MijnLoketPage.class);
        mountPage("voorbeeld", RotterdamPlaceholderPage.class);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return ComponentsPage.class;
    }
}
