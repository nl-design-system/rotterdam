package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

class RdDataSummaryBehavior extends TagNameClassComponentBehavior<RdDataSummary> {

    static final RdDataSummaryBehavior INSTANCE = new RdDataSummaryBehavior();

    private RdDataSummaryBehavior() {
        super("dl", RdDataSummaryCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdDataSummaryBehavior.class, "@utrecht/data-list-css/dist/index.min.css"));
    }
}
