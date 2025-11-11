package nl.rotterdam.wicket.docs.heading;

import nl.rotterdam.nl_design_system.wicket.components.heading.RdHeading;
import nl.rotterdam.nl_design_system.wicket.components.preserve_data.RdPreserveDataLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;

import static nl.rotterdam.nl_design_system.wicket.components.heading.RdHeadingBehavior.heading;

public class HeadingExamplesPanel extends ExamplesPanel {
    public HeadingExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdHeading.class;
    }

    @ComponentExample
    private static RdHeading example10DefaultModel() {
        RdHeading component = new RdHeading("headingDefaultModel", 3);
        component.setDefaultModel(Model.of("Text via defaultModel"));
        return component;
    }

    @ComponentExample
    private static RdHeading example09ModelConstructor() {
        return new RdHeading("headingModelConstructor", Model.of("Text via model constructor"), 3);
    }

    @ComponentExample
    private static RdHeading example08KeepExistingClass() {
        return new RdHeading("bestaandeCssClass", "bestaande CSS class behouden", 4);
    }

    @ComponentExample
    private static RdHeading example06Heading6() {
        return new RdHeading("label6", "Een label met kop 6", 6);
    }

    @ComponentExample
    private static RdHeading example05Heading5() {
        return new RdHeading("label5", "Een label met kop 5", 5);
    }

    @ComponentExample
    private static RdHeading example04Heading4() {
        return new RdHeading("label4", "Een label met kop 4", 4);
    }

    @ComponentExample
    private static RdHeading example03Heading3() {
        return new RdHeading("label3", "Een label met kop 3", 3);
    }

    @ComponentExample
    private static RdHeading example02Heading2() {
        return new RdHeading("label2", "Een label met kop 2", 2);
    }

    @ComponentExample
    private static RdHeading example01Heading1() {
        return new RdHeading("label1", "Een label met kop 1", 1);
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
                add(new RdPreserveDataLabel("name", Model.of("Samira de Jongh")));
            }
        };
    }
}
