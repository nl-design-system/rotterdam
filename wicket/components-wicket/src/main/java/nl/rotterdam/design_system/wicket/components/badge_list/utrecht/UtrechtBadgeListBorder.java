package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import static css.WicketComponentsCssReferences.BADGE_LIST_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtBadgeListBorder extends Border {

    public UtrechtBadgeListBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(BADGE_LIST_HEADER_ITEM);
    }
}
