package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.page_number_navigation.PageNumberNavigationBehavior;
import nl.rotterdam.nl_design_system.wicket.components.page_number_navigation.PageNumberNavigationCssClassnames;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationIncrementLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;

import static nl.rotterdam.nl_design_system.wicket.components.page_number_navigation.PageNumberNavigationCssClassnames.LINK_ELEMENT_BASE;

class RdPagingNavigator extends AjaxPagingNavigator {
    RdPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new TransparentWebMarkupContainer("nldsNavigation") {

            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(PageNumberNavigationBehavior.INSTANCE);
            }
        });
    }

    @Override
    protected PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        System.out.println("Called newNavigation: " + id);
        return new AjaxPagingNavigation(id, pageable, labelProvider) {
            @Override
            protected Link<?> newPagingNavigationLink(String id, IPageable pageable, long pageIndex) {
                return new AjaxPagingNavigationLink(id, pageable, pageIndex) {

                    @Override
                    protected void onInitialize() {
                        super.onInitialize();
                        setAutoEnable(false);
                    }

                    @Override
                    protected boolean useJSEventBindingWhenNeeded() {
                        // having this return true (default) does both Ajax and JavaScript execution of link
                        return false;
                    }

                    @Override
                    protected void onComponentTag(ComponentTag tag) {
                        super.onComponentTag(tag);

                        LINK_ELEMENT_BASE.appendTo(tag);

                        if (pageIndex == pageable.getCurrentPage()) {
                            PageNumberNavigationCssClassnames.LINK_ELEMENT_CURRENT.appendTo(tag);
                            tag.put("aria-current", "true");
                        }
                    }
                };
            }
        };
    }

    @Override
    protected AbstractLink newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {
        return new AjaxPagingNavigationIncrementLink(id, pageable, increment) {
            @Override
            protected boolean useJSEventBindingWhenNeeded() {
                // having this return true (default) does both Ajax and JavaScript execution of link
                return false;
            }
        };
    }

    @Override
    protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
        return new AjaxPagingNavigationLink(id, pageable, pageNumber) {
            @Override
            protected boolean useJSEventBindingWhenNeeded() {
                // having this return true (default) does both Ajax and JavaScript execution of link
                return false;
            }
        };
    }
}
