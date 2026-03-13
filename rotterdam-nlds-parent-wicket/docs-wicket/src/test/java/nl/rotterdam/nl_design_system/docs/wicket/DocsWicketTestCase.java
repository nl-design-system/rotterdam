package nl.rotterdam.nl_design_system.docs.wicket;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.protocol.http.WebApplication;
import org.jspecify.annotations.NonNull;

public class DocsWicketTestCase extends NldsWicketTestCase {

    @Override
    protected @NonNull WebApplication newApplication() {
        return new DocsApplication();
    }
}
