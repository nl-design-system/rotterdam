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
    private static Component example10DefaultModel() {
        return new UtrechtHeading(
            "utrechtHeadingDefaultModel",
            3
        ).setDefaultModel(Model.of("Text via defaultModel"));
    }

    @ComponentExample
    private static UtrechtHeading example09ModelConstructor() {
        return new UtrechtHeading(
            "utrechtHeadingModelConstructor",
            Model.of("Text via model constructor"),
            3
        );
    }

    @ComponentExample
    private static UtrechtHeading example08KeepExistingClass() {
        return new UtrechtHeading(
            "bestaandeCssClass",
            "bestaande CSS class behouden",
            4
        );
    }

    @ComponentExample
    private static UtrechtHeading example06Heading6() {
        return new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6);
    }

    @ComponentExample
    private static UtrechtHeading example07H3MetDivTag() {
        return new UtrechtHeading(
            "utrechtLabel3MetDivTag",
            "div wordt vervangen met h3",
            3
        );
    }

    @ComponentExample
    private static UtrechtHeading example05Heading5() {
        return new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5);
    }

    @ComponentExample
    private static UtrechtHeading example04Heading4() {
        return new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4);
    }

    @ComponentExample
    private static UtrechtHeading example03Heading3() {
        return new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3);
    }

    @ComponentExample
    private static UtrechtHeading example02Heading2() {
        return new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2);
    }

    @ComponentExample
    private static UtrechtHeading example01Heading1() {
        return new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            example01Heading1(),
            example02Heading2(),
            example03Heading3(),
            example04Heading4(),
            example05Heading5(),
            example06Heading6(),
            example07H3MetDivTag(),
            example08KeepExistingClass(),
            example09ModelConstructor(),
            example10DefaultModel(),
            example11UntranslatableContent()
        );
    }

    @ComponentExample
    private WebMarkupContainer example11UntranslatableContent() {
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
