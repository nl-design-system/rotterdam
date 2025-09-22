package css;


import java.util.Arrays;
import java.util.stream.Collectors;

public class HTMLUtil {

    public static String className(String... classesWithValuesAndNulls) {
        return joinTokens(classesWithValuesAndNulls);
    }

    public static String idRefs(String... idsWithValuesAndNulls) {
        return joinTokens(idsWithValuesAndNulls);
    }

    public static String joinTokens(String... tokensWithValuesAndNulls) {
        return Arrays
            .stream(tokensWithValuesAndNulls)
            .filter(className -> className != null && !className.trim().isEmpty())
            .collect(Collectors.joining(" "));
    }
}
