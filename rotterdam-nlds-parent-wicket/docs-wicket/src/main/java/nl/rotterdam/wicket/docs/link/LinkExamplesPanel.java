package nl.rotterdam.wicket.docs.link;

import nl.rotterdam.nl_design_system.wicket.components.link.utrecht.UtrechtBookmarkableLink;
import nl.rotterdam.nl_design_system.wicket.components.link.utrecht.UtrechtExternalLink;
import nl.rotterdam.nl_design_system.wicket.components.link.utrecht.UtrechtLink;
import nl.rotterdam.nl_design_system.wicket.components.link.utrecht.UtrechtLinkBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ComponentsPage;
import nl.rotterdam.wicket.docs.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class LinkExamplesPanel extends Panel {

    public LinkExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleLinkLabel() {
        // Vanilla Apache Wicket implementation, for reference
        return new Link<Void>("standardLink") {
            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };
    }

    @ComponentExample
    private static Component exampleLinkExternal() {
        // Vanilla Apache Wicket implementation, for reference
        return new ExternalLink("standardLinkExternal", "https://example.com/", "example.com");
    }

    @ComponentExample
    private static Component exampleUtrechtLink() {
        return new UtrechtLink<>("link", Model.of("Homepage"), ComponentsPage.class);
    }

    @ComponentExample
    private static Component exampleUtrechtBookmarkableLink() {
        return new UtrechtBookmarkableLink<>("bookmarkableLink", MijnLoketPage.class);
    }

    @ComponentExample
    private static Component exampleUtrechtBookmarkableLinkCurrent() {
        return new UtrechtBookmarkableLink<>("bookmarkableLinkCurrent", ComponentsPage.class);
    }

    @ComponentExample
    private static Component exampleUtrechtLinkExternal() {
        return new UtrechtExternalLink("linkExternal", "https://example.com", "example.com");
    }

    @ComponentExample
    private static Component exampleUtrechtLinkBehavior() {
        return new Link<>("linkBehavior", Model.of("Homepage")) {
            @Override
            public void onInitialize() {
                super.onInitialize();
                add(new UtrechtLinkBehavior());
            }

            @Override
            public void onClick() {
                setResponsePage(ComponentsPage.class);
            }
        };
    }

    @ComponentExample
    private static Component exampleUtrechtLinkExternalBehavior() {
        return new ExternalLink("linkExternalBehavior", "https://example.com/", "example.com") {
            @Override
            public void onInitialize() {
                super.onInitialize();
                add(new UtrechtLinkBehavior());
            }
        };
    }

    @ComponentExample
    private static Component exampleUtrechtLinkPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        UtrechtLink<String, ComponentsPage> link = new UtrechtLink<>(
            "linkPlaceholder",
            Model.of("Homepage"),
            ComponentsPage.class
        );

        link.setPlaceholder(true);
        return link;
    }

    @ComponentExample
    private static Component exampleUtrechtLinkExternalPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        UtrechtExternalLink link = new UtrechtExternalLink(
            "linkExternalPlaceholder",
            "https://example.com/",
            "example.com"
        );

        link.setPlaceholder(true);
        return link;
    }

    @ComponentExample
    private static Component exampleUtrechtBookmarkableLinkPlaceholder() {
        // `setDisabled()` is default functionality on `Link`
        UtrechtBookmarkableLink<?> link = new UtrechtBookmarkableLink<>(
            "bookmarkableLinkPlaceholder",
            ComponentsPage.class
        );

        link.setPlaceholder(true);
        return link;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLinkLabel());
        add(exampleLinkExternal());
        add(exampleUtrechtLink());
        add(exampleUtrechtBookmarkableLink());
        add(exampleUtrechtBookmarkableLinkCurrent());
        add(exampleUtrechtLinkExternal());
        add(exampleUtrechtLinkBehavior());
        add(exampleUtrechtLinkExternalBehavior());
        add(exampleUtrechtLinkPlaceholder());
        add(exampleUtrechtLinkExternalPlaceholder());
        add(exampleUtrechtBookmarkableLinkPlaceholder());
    }
}
