package nl.rotterdam.wicket.docs;

import nl.utrecht.components.UtrechtCodeBlock;
import org.apache.wicket.model.Model;

// import nl.utrecht.components.UtrechtUnorderedList;

public class Components extends EmptyPage {

  public Components() {
    add(new Label(TITLE_ID, "Components · Apache Wicket · Rotterdam Design System"));

    add(new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")));
  }
}
