package nl.rotterdam.wicket.docs;

import css.RotterdamNLDCssReferences;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public abstract class BasePage extends WebPage {

  public static final String TITLE_ID = "title";

  @Override
  public void renderHead(IHeaderResponse response) {
    super.renderHead(response);

    response.render(
      CssHeaderItem.forReference(RotterdamNLDCssReferences.PARAGRAPH)
    );
    response.render(
      CssHeaderItem.forReference(RotterdamNLDCssReferences.THEME)
    );
    response.render(
      CssHeaderItem.forReference(RotterdamNLDCssReferences.INDEX)
    );

    response.render(
      CssHeaderItem.forReference(
        new CssResourceReference(BasePage.class, "docs.css")
      )
    );
  }

  public BasePage() {}
}
