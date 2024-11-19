package nl.rotterdam.wicket.docs;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

import static css.NlDesignSystemCssReferences.PARAGRAPH_CSS_HEADER_ITEM;
import static css.NlDesignSystemCssReferences.THEME_CSS_HEADER_ITEM;

public abstract class BasePage extends WebPage {

  public static final String TITLE_ID = "title";
  public static final CssReferenceHeaderItem DOCS_CSS_HEADER_ITEM =
          CssHeaderItem.forReference(
                  new CssResourceReference(BasePage.class, "docs.css")
          );

  public BasePage() {
  }

    @Override
    public void renderHead(IHeaderResponse response) {
      super.renderHead(response);

      // we add it here because we also have paragraphs without wicket NlParagraph / NlParagraphBehavior component
      response.render(PARAGRAPH_CSS_HEADER_ITEM);

      // TODO: theme should not be an explicit dependency, but is there an ordering relation between component css files and the theme CSS files?
      response.render(THEME_CSS_HEADER_ITEM);
      response.render(DOCS_CSS_HEADER_ITEM);
    }
}
