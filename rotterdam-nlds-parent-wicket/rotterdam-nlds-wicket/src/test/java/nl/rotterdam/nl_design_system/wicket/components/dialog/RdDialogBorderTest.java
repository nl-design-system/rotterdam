package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestHandler;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RdDialogBorderTest extends NldsWicketTestCase {

    @Test
    void doesNotRenderContentInitially() {
        var dialog = new RdDialogBorder(
            "dialog",
            Model.of("Some string"),
            () -> AttributeAppender.append("class", "icon-class"),
            RdDialogHeadingLevel.LEVEL_1
        ) {
            @Override
            protected Component newFooterContent(String id) {
                var footerContent = new WebMarkupContainer(id);
                footerContent.setMarkup(Markup.of("<div wicket:id='" + id + "'>Some string</div>"));
                return footerContent;
            }

            @Override
            protected void onClose(AjaxRequestTarget target) {
                // No action needed. Only testing the generated markup.
            }
        }
            .setMarkup(Markup.of("<dialog wicket:id='dialog'>Content</dialog>"));

        // language=HTML
        String expectedHtmlFragment = """
            <dialog id="dialog1" class="ams-dialog">
                <div id="content2" hidden data-wicket-placeholder=""></div>
            </dialog>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(dialog).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @ParameterizedTest
    @EnumSource(RdDialogHeadingLevel.class)
    void render(RdDialogHeadingLevel level) {
        var dialog = new RdDialogBorder(
            "dialog",
            Model.of("Title"),
            () -> AttributeAppender.append("class", "icon-class"),
            level
        ) {
            @Override
            protected Component newFooterContent(String id) {
                var footerContent = new WebMarkupContainer(id);
                footerContent.setMarkup(Markup.of("<div wicket:id='" + id + "'>Footer</div>"));
                return footerContent;
            }

            @Override
            protected void onClose(AjaxRequestTarget target) {
                // No action needed. Only testing the generated markup.
            }
        };
        dialog.setMarkup(Markup.of("<dialog wicket:id='dialog'>Content</dialog>"));
        dialog.showModal(new AjaxRequestHandler(new Page() {
        }));

        // language=HTML
        var levelAsNumber = level.getLevel();
        String expectedHtmlFragment = """
            <dialog id="dialog2" class="ams-dialog">
                <div id="content1">
                    <header class="ams-dialog__header">
                        <h%s class="utrecht-heading-%s">Title</h%s>
                        <button name="dialog:content:closeButton" id="closeButton3" class="ams-icon-button"><span class="ams-visually-hidden">Close</span><span class="utrecht-icon"> <span class="icon-class"></span> </span></button>
                    </header>
                    <div class="ams-dialog__body">Content</div>
                    <footer class="ams-dialog__footer">
                        <div>Footer</div>
                    </footer>
                </div>
            </dialog>"""
            .formatted(levelAsNumber, levelAsNumber, levelAsNumber);

        String actualHtmlFragment = ComponentRenderer.renderComponent(dialog).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void usesCustomCloseButtonLabel() {
        var dialog = new RdDialogBorder(
            "dialog",
            Model.of("Title"),
            () -> AttributeAppender.append("class", "icon-class"),
            Model.of("Close button label"),
            RdDialogHeadingLevel.LEVEL_1
        ) {
            @Override
            protected Component newFooterContent(String id) {
                var footerContent = new WebMarkupContainer(id);
                footerContent.setMarkup(Markup.of("<div wicket:id='" + id + "'>Footer</div>"));
                return footerContent;
            }

            @Override
            protected void onClose(AjaxRequestTarget target) {
                // No action needed. Only testing the generated markup.
            }
        };
        dialog.setMarkup(Markup.of("<dialog wicket:id='dialog'>Content</dialog>"));
        dialog.showModal(new AjaxRequestHandler(new Page() {
        }));

        // language=HTML
        String expectedHtmlFragment = """
            <dialog id="dialog2" class="ams-dialog">
                <div id="content1">
                    <header class="ams-dialog__header">
                        <h1 class="utrecht-heading-1">Title</h1>
                        <button name="dialog:content:closeButton" id="closeButton3" class="ams-icon-button"><span class="ams-visually-hidden">Close button label</span><span class="utrecht-icon"> <span class="icon-class"></span> </span></button>
                    </header>
                    <div class="ams-dialog__body">Content</div>
                    <footer class="ams-dialog__footer">
                        <div>Footer</div>
                    </footer>
                </div>
            </dialog>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(dialog).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
