package nl.rotterdam.design_system.wicket.components.data_summary;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdDataSummaryBehavior extends TagNameClassComponentBehavior<RdDataSummary> {

    static final RdDataSummaryBehavior INSTANCE = new RdDataSummaryBehavior();

    private RdDataSummaryBehavior() {
        super("dl", RdDataSummaryCss.DEFAULT);

        addHeaderItem(cssReferenceHeaderItem(RdDataSummaryBehavior.class,
            "@utrecht/data-list-css/dist/index.css"));
    }

}
