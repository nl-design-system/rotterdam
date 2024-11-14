package nl.rotterdam.wicket.nl_design.docs;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.ee10.webapp.WebAppContext ;

import java.time.Duration;

import static nl.rotterdam.wicket.nl_design.docs.ModuleRootResolver.resolveModuleRootPath;

public class Start {

    public static final int PORT = 8945;

    public static void main(final String[] args) {
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
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER on http://localhost:" + PORT + ", PRESS ANY KEY TO STOP");
            server.start();
            System.in.read();
            System.out.println(">>> STOPPING EMBEDDED JETTY SERVER");
            server.stop();
            server.join();
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
