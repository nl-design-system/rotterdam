package nl.rotterdam.nl_design_system.docs.wicket.link;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentsPage;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page.MijnLoketPage;
import nl.rotterdam.nl_design_system.wicket.components.link.RdBookmarkableLink;
import nl.rotterdam.nl_design_system.wicket.components.link.RdExternalLink;
import nl.rotterdam.nl_design_system.wicket.components.link.RdLink;
import nl.rotterdam.nl_design_system.wicket.components.link.RdLinkBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class LinkExamplesPanel extends ExamplesPanel {

    public LinkExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return Link.class;
    }

    @ComponentExample
    private static Component exampleStandardLinkLabel() {
        // Vanilla Apache Wicket implementation, for reference
        return new Link<Void>("standardLink") {
            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };
    }

    @ComponentExample
    private static Component exampleStandardLinkExternal() {
        // Vanilla Apache Wicket implementation, for reference
        return new ExternalLink("standardLinkExternal", "https://example.com/", "example.com");
    }

    @ComponentExample
    private static Component exampleLink() {
        return new RdLink<>("link", Model.of("Homepage")) {
            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };
    }

    @ComponentExample
    private static Component exampleBookmarkableLink() {
        return new RdBookmarkableLink<>("bookmarkableLink", MijnLoketPage.class);
    }

    @ComponentExample
    private static Component exampleBookmarkableLinkCurrent() {
        return new RdBookmarkableLink<>("bookmarkableLinkCurrent", ComponentsPage.class);
    }

    @ComponentExample
    private static Component exampleLinkExternal() {
        return new RdExternalLink("linkExternal", "https://example.com", "example.com");
    }

    @ComponentExample
    private static Component exampleLinkBehavior() {
        return new Link<>("linkBehavior", Model.of("Homepage")) {
            @Override
            public void onInitialize() {
                super.onInitialize();
                add(RdLinkBehavior.INSTANCE);
            }

            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };
    }

    @ComponentExample
    private static Component exampleLinkExternalBehavior() {
        return new ExternalLink("linkExternalBehavior", "https://example.com/", "example.com") {
            @Override
            public void onInitialize() {
                super.onInitialize();
                add(RdLinkBehavior.INSTANCE);
            }
        };
    }

    @ComponentExample
    private static Component exampleLinkPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        RdLink<String> link = new RdLink<>("linkPlaceholder", Model.of("Homepage")) {
            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };

        link.setIsPlaceholder(true);
        return link;
    }

    @ComponentExample
    private static Component exampleLinkExternalPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        RdExternalLink link = new RdExternalLink(
            "linkExternalPlaceholder",
            "https://example.com/",
            "example.com"
        );

        link.setIsPlaceholder(true);
        return link;
    }

    @ComponentExample
    private static Component exampleBookmarkableLinkPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        RdBookmarkableLink<?> link = new RdBookmarkableLink<>(
            "bookmarkableLinkPlaceholder",
            ComponentsPage.class
        );

        link.setPlaceholder(true);
        return link;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleStandardLinkLabel());
        add(exampleStandardLinkExternal());
        add(exampleLink());
        add(exampleBookmarkableLink());
        add(exampleBookmarkableLinkCurrent());
        add(exampleLinkExternal());
        add(exampleLinkBehavior());
        add(exampleLinkExternalBehavior());
        add(exampleLinkPlaceholder());
        add(exampleLinkExternalPlaceholder());
        add(exampleBookmarkableLinkPlaceholder());
    }
}
