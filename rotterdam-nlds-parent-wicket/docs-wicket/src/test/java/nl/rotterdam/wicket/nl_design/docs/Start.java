package nl.rotterdam.wicket.nl_design.docs;

import static nl.rotterdam.wicket.nl_design.docs.ModuleRootResolver.resolveModuleRootPath;

import java.time.Duration;
import nl.rotterdam.wicket.nl_design.docs.storybook_generator.GenerateMarkdownAndStorybookExamplesMain;
import org.eclipse.jetty.ee10.webapp.WebAppContext;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Start {

    public static final int PORT = 8945;

    @SuppressWarnings({ "CallToPrintStackTrace", "ResultOfMethodCallIgnored" })
    public static void main(final String[] args) {
        GenerateMarkdownAndStorybookExamplesMain.main(args);

        final int timeout = (int) Duration.ofHours(1L).toMillis();

        final Server server = new Server();

        final HttpConfiguration http_config = new HttpConfiguration();

        final ServerConnector connector = new ServerConnector(server, new HttpConnectionFactory(http_config));
        connector.setPort(PORT);
        connector.setIdleTimeout(timeout);

        server.addConnector(connector);

        final WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/");
        bb.setWar(resolveModuleRootPath(Start.class) + "/src/main/webapp");
        server.setHandler(bb);

        try {
            server.start();

            System.out.println(
                """
                ╭──────────────────────────────────────────────────────────────────────────────────────────────────╮
                │                                                                                                  │
                │   Development server has started for:                                                            │
                │   NL Design System community components for Apache Wicket                                        │
                │                                                                                                  │
                │    Local:            http://localhost:1234/                                                      │
                │                                                                                                  │
                │   Restart this server to see any changes you have made to components or design tokens.           │
                │                                                                                                  │
                │   Read the latest documentation:                                                                 │
                │   https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/README.md │
                │                                                                                                  │
                ╰──────────────────────────────────────────────────────────────────────────────────────────────────╯
                """.replace("1234", Integer.toString(PORT))
            );

            System.in.read();
            System.out.println(">>> Stopping development server...");
            server.stop();
            server.join();
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
