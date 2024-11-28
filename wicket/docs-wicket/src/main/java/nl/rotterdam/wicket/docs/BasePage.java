package nl.rotterdam.wicket.docs;

import static css.DesignTokensWicketCssReference.THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM;
import static css.WicketComponentsCssReferences.ALERT_HEADER_ITEM;
import static css.WicketComponentsCssReferences.BADGE_LIST_HEADER_ITEM;
import static css.WicketComponentsCssReferences.BODY_HEADER_ITEM;
import static css.WicketComponentsCssReferences.BUTTON_GROUP_HEADER_ITEM;
import static css.WicketComponentsCssReferences.CHECKBOX_HEADER_ITEM;
import static css.WicketComponentsCssReferences.COLUMN_LAYOUT_HEADER_ITEM;
import static css.WicketComponentsCssReferences.CUSTOM_CHECKBOX_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_DESCRIPTION_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_ERROR_MESSAGE_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_LABEL_HEADER_ITEM;
import static css.WicketComponentsCssReferences.HEADING_GROUP_HEADER_ITEM;
import static css.WicketComponentsCssReferences.HTML_CONTENT_HEADER_ITEM;
import static css.WicketComponentsCssReferences.ICON_HEADER_ITEM;
import static css.WicketComponentsCssReferences.LOGO_HEADER_ITEM;
import static css.WicketComponentsCssReferences.NUMBER_BADGE_HEADER_ITEM;
import static css.WicketComponentsCssReferences.ORDERED_LIST_HEADER_ITEM;
import static css.WicketComponentsCssReferences.PAGE_BODY_HEADER_ITEM;
import static css.WicketComponentsCssReferences.PAGE_FOOTER_HEADER_ITEM;
import static css.WicketComponentsCssReferences.PAGE_HEADER_HEADER_ITEM;
import static css.WicketComponentsCssReferences.PAGE_LAYOUT_HEADER_ITEM;
import static css.WicketComponentsCssReferences.ROOT_HEADER_ITEM;
import static css.WicketComponentsCssReferences.SEPARATOR_HEADER_ITEM;
import static css.WicketComponentsCssReferences.THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM;
import static css.WicketComponentsCssReferences.UNORDERED_LIST_HEADER_ITEM;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public abstract class BasePage extends WebPage {

    public static final String TITLE_ID = "title";
    public static final CssReferenceHeaderItem DOCS_CSS_HEADER_ITEM = CssHeaderItem.forReference(
        new CssResourceReference(BasePage.class, "docs.css")
    );

    public BasePage() {}

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM);
        response.render(THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM);
        response.render(DOCS_CSS_HEADER_ITEM);
        response.render(ROOT_HEADER_ITEM);
        response.render(BODY_HEADER_ITEM);
        response.render(PAGE_BODY_HEADER_ITEM);
        response.render(PAGE_HEADER_HEADER_ITEM);
        response.render(PAGE_FOOTER_HEADER_ITEM);
        response.render(PAGE_LAYOUT_HEADER_ITEM);
        response.render(HTML_CONTENT_HEADER_ITEM);
        response.render(FORM_LABEL_HEADER_ITEM);
        response.render(NUMBER_BADGE_HEADER_ITEM);
        response.render(BUTTON_GROUP_HEADER_ITEM);
        response.render(ALERT_HEADER_ITEM);
        response.render(BADGE_LIST_HEADER_ITEM);
        response.render(SEPARATOR_HEADER_ITEM);
        response.render(ORDERED_LIST_HEADER_ITEM);
        response.render(UNORDERED_LIST_HEADER_ITEM);
        response.render(ICON_HEADER_ITEM);
        response.render(COLUMN_LAYOUT_HEADER_ITEM);
        response.render(HEADING_GROUP_HEADER_ITEM);
        response.render(LOGO_HEADER_ITEM);
        response.render(FORM_FIELD_HEADER_ITEM);
        response.render(FORM_FIELD_DESCRIPTION_HEADER_ITEM);
        response.render(FORM_FIELD_ERROR_MESSAGE_HEADER_ITEM);
        response.render(CHECKBOX_HEADER_ITEM);
        response.render(CUSTOM_CHECKBOX_HEADER_ITEM);
    }
}
