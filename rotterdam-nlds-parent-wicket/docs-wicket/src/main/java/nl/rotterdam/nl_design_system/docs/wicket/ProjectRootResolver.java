package nl.rotterdam.nl_design_system.docs.wicket;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import static java.util.Objects.requireNonNull;

public class ProjectRootResolver {

    private ProjectRootResolver() {
    }

    public static File resolveProjectRootDir(Class<?> classInProject) {
        try {
            URI uri = requireNonNull(classInProject.getResource("/logback.xml")).toURI();
            File file = new File(uri);
            while (!new File(file, "pom.xml").exists()) {
                file = file.getParentFile();
            }
            return file;
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}