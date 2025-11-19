package nl.rotterdam.nl_design_system.docs.wicket;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class ModuleRootResolver {

    public static File resolveModuleRootPath(Class<?> classInProject) {
        try {
            URI uri = Objects.requireNonNull(classInProject.getResource(classInProject.getSimpleName() + ".class")).toURI();
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
