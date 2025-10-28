package nl.rotterdam.wicket.nl_design.docs;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class ModuleRootResolver {

    public static File resolveModuleRootPath(Class<?> classInProject) {
        try {
            URI uri = Objects.requireNonNull(classInProject.getResource(".")).toURI();
            File file = new File(uri);
            while (!new File(file, "pom.xml").exists()) {
                file = file.getParentFile();
            }

            return file;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
