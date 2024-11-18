package nl.rotterdam.wicket.docs.heading;

import nl.rotterdam.nl_design.wicket.components.heading.UtrechtHeading;
import nl.rotterdam.nl_design.wicket.components.untranslatable.UtrechtUntranslatableLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.nl_design.wicket.components.heading.UtrechtHeadingBehavior.heading;

public class HeadingPanel extends Panel {

    public HeadingPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1));
        add(new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2));
        add(new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3));
        add(new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4));
        add(new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5));
        add(new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6));

        add(new UtrechtHeading("utrechtLabel3MetDivTag", "div wordt vervangen met h3", 3));

        add(new UtrechtHeading("bestaandeCssClass", "bestaande CSS class behouden",4));

        add(
            new UtrechtHeading("utrechtHeadingModelConstructor", Model.of("Text via model constructor"),3)
        );

        add(
            new UtrechtHeading("utrechtHeadingDefaultModel", 3)
                .setDefaultModel(Model.of("Text via defaultModel"))
        );

        add(new WebMarkupContainer("headingMetUntranslatableContent") {
                @Override
                protected void onInitialize() {
                    super.onInitialize();
                    add(heading(1));
                    add(
                        new UtrechtUntranslatableLabel(
                            "name",
                            Model.of("Samira de Jongh")
                        )
                    );
                }
            }
        );
    }
}
