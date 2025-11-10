package nl.rotterdam.wicket.docs.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.icon.rotterdam.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.wicket.components.icon_button.RdIconAjaxButtonBorder;
import nl.rotterdam.nl_design_system.wicket.components.icon_button.RdIconButtonBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class IconButtonExamplesPanel extends ExamplesPanel {
    public IconButtonExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdIconButtonBorder.class;
    }

    @ComponentExample
    private static Form<Void> ajaxButton() {
        var form = new Form<Void>("formOfAjaxButton");

        var button = new RdIconAjaxButtonBorder("button", Model.of("send")) {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                System.out.println("Send geklikt");
            }
        };
        form.add(button);

        var icon = new WebMarkupContainer("icon");
        icon.add(RotterdamIconBehavior.SEND);
        button.add(icon);

        return form;
    }

    @ComponentExample
    private static Form<Void> button() {
        var form = new Form<Void>("formOfButton");

        var button = new RdIconButtonBorder("button", Model.of("edit")) {
            @Override
            public void onSubmit() {
                System.out.println("Edit geklikt");
            }
        };
        form.add(button);

        var icon = new WebMarkupContainer("icon");
        icon.add(RotterdamIconBehavior.EDIT);
        button.add(icon);

        return form;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(ajaxButton());
        add(button());
    }
}
