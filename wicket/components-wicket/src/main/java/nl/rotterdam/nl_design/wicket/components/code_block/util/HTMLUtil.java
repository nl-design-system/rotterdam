package nl.rotterdam.nl_design.wicket.components.code_block.util;

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
    return Arrays.asList(classes)
      .stream()
      .filter(className -> className != null && !className.trim().isEmpty())
      .collect(Collectors.joining(" "));
  }
}
