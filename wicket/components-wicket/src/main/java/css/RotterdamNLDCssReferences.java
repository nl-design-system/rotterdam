package css;

import org.apache.wicket.request.resource.CssResourceReference;

public class RotterdamNLDCssReferences {

  public static final CssResourceReference PARAGRAPH = makeReference(
    "paragraph.css"
  );
  public static final CssResourceReference INDEX = makeReference("index.css");
  public static final CssResourceReference THEME = makeReference("theme.css");

  private static CssResourceReference makeReference(String file) {
    return new CssResourceReference(RotterdamNLDCssReferences.class, file);
  }
}
