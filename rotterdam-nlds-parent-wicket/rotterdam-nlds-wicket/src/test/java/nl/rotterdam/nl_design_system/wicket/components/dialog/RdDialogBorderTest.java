package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.test_common.NldsWicketTestCase;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RdDialogBorderTest extends NldsWicketTestCase {

    @ParameterizedTest
    @EnumSource(RdDialogHeadingLevel.class)
    void render(RdDialogHeadingLevel level) {
        var dialog = new RdDialogBorder("dialog", Model.of("Title"), level) {
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
        }
            .setMarkup(Markup.of("<dialog wicket:id='dialog'>Content</dialog>"));

        // language=HTML
        var levelAsNumber = level.getLevel();
        String expectedHtmlFragment = """
            <dialog id="dialog1" class="ams-dialog">
                <header class="ams-dialog__header">
                    <h%s class="utrecht-heading-%s">Title</h%s>
                    <button name="dialog:closeButton" id="closeButton2" class="ams-icon-button"><span class="ams-visually-hidden">Close</span><span class="ams-icon ams-icon--square ams-icon--heading-%s"><rods-icon-close></rods-icon-close></span></button>
                </header>
                <div class="ams-dialog__body">Content</div>
                <footer class="ams-dialog__footer">
                    <div>Footer</div>
                </footer>
            </dialog>"""
            .formatted(levelAsNumber, levelAsNumber, levelAsNumber, levelAsNumber);

        String actualHtmlFragment = ComponentRenderer.renderComponent(dialog).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }

    @Test
    void usesCustomCloseButtonLabel() {
        var dialog = new RdDialogBorder("dialog", Model.of("Title"), Model.of("Close button label"), RdDialogHeadingLevel.LEVEL_1) {
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
        }
            .setMarkup(Markup.of("<dialog wicket:id='dialog'>Content</dialog>"));

        // language=HTML
        String expectedHtmlFragment = """
            <dialog id="dialog1" class="ams-dialog">
                <header class="ams-dialog__header">
                    <h1 class="utrecht-heading-1">Title</h1>
                    <button name="dialog:closeButton" id="closeButton2" class="ams-icon-button"><span class="ams-visually-hidden">Close button label</span><span class="ams-icon ams-icon--square ams-icon--heading-1"><rods-icon-close></rods-icon-close></span></button>
                </header>
                <div class="ams-dialog__body">Content</div>
                <footer class="ams-dialog__footer">
                    <div>Footer</div>
                </footer>
            </dialog>""";

        String actualHtmlFragment = ComponentRenderer.renderComponent(dialog).toString();

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
    }
}
