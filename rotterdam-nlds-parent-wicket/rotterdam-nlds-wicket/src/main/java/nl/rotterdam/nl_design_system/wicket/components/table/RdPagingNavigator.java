package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.page_number_navigation.PageNumberNavigationBehavior;
import nl.rotterdam.nl_design_system.wicket.components.page_number_navigation.PageNumberNavigationCss;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationIncrementLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;


class RdPagingNavigator extends AjaxPagingNavigator {
    RdPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new TransparentWebMarkupContainer("page-number-navigation") {

            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(PageNumberNavigationBehavior.INSTANCE);

                add(new TransparentWebMarkupContainer("before")
                    .add(PageNumberNavigationCss.BEFORE.asBehavior()),

                    new TransparentWebMarkupContainer("pages")
                        .add(AttributeModifier.replace("role", "group"))
                        .add(PageNumberNavigationCss.LINK_ELEMENT_PAGES.asBehavior()),

                    new TransparentWebMarkupContainer("after")
                    .add(PageNumberNavigationCss.AFTER.asBehavior())
                );
            }
        });
    }

    @Override
    protected PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
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

                        PageNumberNavigationCss.LINK_ELEMENT_NON_RELATIVE.appendTo(tag);

                        if (pageIndex == pageable.getCurrentPage()) {
                            PageNumberNavigationCss.LINK_ELEMENT_CURRENT.appendTo(tag);
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

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);


                if (getId().equals("prev")) {
                    tag.put("rel", "prev");
                    PageNumberNavigationCss.LINK_ELEMENT_RELATIVE.appendTo(tag);
                    PageNumberNavigationCss.LINK_ELEMENT_RELATIVE_PREV.appendTo(tag);

                    if (pageable.getCurrentPage() == 0) {
                        PageNumberNavigationCss.LINK_ELEMENT_RELATIVE_DISABLED.appendTo(tag);
                    }
                }
                if (getId().equals("next")) {
                    tag.put("rel", "next");

                    PageNumberNavigationCss.LINK_ELEMENT_RELATIVE.appendTo(tag);
                    PageNumberNavigationCss.LINK_ELEMENT_RELATIVE_NEXT.appendTo(tag);

                    if (pageable.getCurrentPage() == getPageNumber()) {
                        PageNumberNavigationCss.LINK_ELEMENT_RELATIVE_DISABLED.appendTo(tag);
                    }
                }

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

            @Override
            protected void onInitialize() {
                super.onInitialize();

                // first not part of nl design system pagination
                if (getId().equals("first")) {
                    setVisibilityAllowed(false);
                }

                // last not part of nl design system pagination
                if (getId().equals("last")) {
                    setVisibilityAllowed(false);
                }
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                PageNumberNavigationCss.LINK_ELEMENT_NON_RELATIVE.appendTo(tag);
            }
        };
    }
}
