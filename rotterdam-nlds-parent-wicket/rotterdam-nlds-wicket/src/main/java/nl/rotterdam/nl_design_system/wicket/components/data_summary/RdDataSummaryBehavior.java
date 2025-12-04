package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdDataSummaryBehavior extends TagNameClassComponentBehavior<RdDataSummary> {

    static final RdDataSummaryBehavior INSTANCE = new RdDataSummaryBehavior();

    private RdDataSummaryBehavior() {
        super("dl", RdDataSummaryCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdDataSummaryBehavior.class, "@utrecht/data-list-css/dist/index.min.css"));
    }
}
