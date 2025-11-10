package nl.rotterdam.wicket.docs.heading;

import nl.rotterdam.nl_design_system.wicket.components.heading.utrecht.UtrechtHeading;
import nl.rotterdam.nl_design_system.wicket.components.preserve_data.utrecht.UtrechtPreserveDataLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;

import static nl.rotterdam.nl_design_system.wicket.components.heading.utrecht.UtrechtHeadingBehavior.heading;

public class HeadingExamplesPanel extends ExamplesPanel {
    public HeadingExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtHeading.class;
    }

    @ComponentExample
    private static UtrechtHeading example10DefaultModel() {
        UtrechtHeading component = new UtrechtHeading("headingDefaultModel", 3);
        component.setDefaultModel(Model.of("Text via defaultModel"));
        return component;
    }

    @ComponentExample
    private static UtrechtHeading example09ModelConstructor() {
        return new UtrechtHeading("headingModelConstructor", Model.of("Text via model constructor"), 3);
    }

    @ComponentExample
    private static UtrechtHeading example08KeepExistingClass() {
        return new UtrechtHeading("bestaandeCssClass", "bestaande CSS class behouden", 4);
    }

    @ComponentExample
    private static UtrechtHeading example06Heading6() {
        return new UtrechtHeading("label6", "Een label met kop 6", 6);
    }

    @ComponentExample
    private static UtrechtHeading example07H3MetDivTag() {
        return new UtrechtHeading("label3MetDivTag", "div wordt vervangen met h3", 3);
    }

    @ComponentExample
    private static UtrechtHeading example05Heading5() {
        return new UtrechtHeading("label5", "Een label met kop 5", 5);
    }

    @ComponentExample
    private static UtrechtHeading example04Heading4() {
        return new UtrechtHeading("label4", "Een label met kop 4", 4);
    }

    @ComponentExample
    private static UtrechtHeading example03Heading3() {
        return new UtrechtHeading("label3", "Een label met kop 3", 3);
    }

    @ComponentExample
    private static UtrechtHeading example02Heading2() {
        return new UtrechtHeading("label2", "Een label met kop 2", 2);
    }

    @ComponentExample
    private static UtrechtHeading example01Heading1() {
        return new UtrechtHeading("label1", "Een label met kop 1", 1);
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
                add(new UtrechtPreserveDataLabel("name", Model.of("Samira de Jongh")));
            }
        };
    }
}
