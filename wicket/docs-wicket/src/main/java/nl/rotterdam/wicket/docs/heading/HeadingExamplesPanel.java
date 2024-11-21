package nl.rotterdam.wicket.docs.heading;

import nl.rotterdam.nl_design.wicket.components.heading.UtrechtHeading;
import nl.rotterdam.nl_design.wicket.components.untranslatable.UtrechtUntranslatableLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.nl_design.wicket.components.heading.UtrechtHeadingBehavior.heading;

public class HeadingExamplesPanel extends Panel {

    public HeadingExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleDefaultModel() {
        return new UtrechtHeading(
            "utrechtHeadingDefaultModel",
            3
        ).setDefaultModel(Model.of("Text via defaultModel"));
    }

    @ComponentExample
    private static UtrechtHeading exampleModelConstructor() {
        return new UtrechtHeading(
            "utrechtHeadingModelConstructor",
            Model.of("Text via model constructor"),
            3
        );
    }

    @ComponentExample
    private static UtrechtHeading exampleKeepExistingClass() {
        return new UtrechtHeading(
            "bestaandeCssClass",
            "bestaande CSS class behouden",
            4
        );
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading6() {
        return new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6);
    }

    @ComponentExample
    private static UtrechtHeading exampleH3MetDivTag() {
        return new UtrechtHeading(
            "utrechtLabel3MetDivTag",
            "div wordt vervangen met h3",
            3
        );
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading5() {
        return new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5);
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading4() {
        return new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4);
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading3() {
        return new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3);
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading2() {
        return new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2);
    }

    @ComponentExample
    private static UtrechtHeading exampleHeading1() {
        return new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleHeading1(),
            exampleHeading2(),
            exampleHeading3(),
            exampleHeading4(),
            exampleHeading5(),
            exampleHeading6(),
            exampleH3MetDivTag(),
            exampleKeepExistingClass(),
            exampleModelConstructor(),
            exampleDefaultModel(),
            exampleUntranslatableContent()
        );
    }

    @ComponentExample
    private WebMarkupContainer exampleUntranslatableContent() {
        return new WebMarkupContainer("headingMetUntranslatableContent") {
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
        };
    }
}
