package css;


import java.util.Arrays;
import java.util.stream.Collectors;

public class HTMLUtil {

    public static String className(String... classes) {
        return joinTokens(classes);
    }

    public static String idRefs(String... classes) {
        return joinTokens(classes);
    }

    public static String joinTokens(String... classes) {
        return Arrays
            .stream(classes)
            .filter(className -> className != null && !className.trim().isEmpty())
            .collect(Collectors.joining(" "));
    }
}
