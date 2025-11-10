package nl.rotterdam.wicket.docs.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.paragraph.RdParagraph;
import nl.rotterdam.nl_design_system.wicket.components.paragraph.RdParagraphAppearance;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.Component;

public class ParagraphExamplesPanel extends ExamplesPanel {

    public ParagraphExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdParagraph.class;
    }

    @ComponentExample
    private static Component exampleParagraph() {
        return new RdParagraph("paragraph", "Lorem ipsum dolor sit amet");
    }

    @ComponentExample
    private static Component exampleParagraphLead() {
        return new RdParagraph("paragraphLead", "Lorem ipsum dolor sit amet", RdParagraphAppearance.LEAD);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleParagraph());
        add(exampleParagraphLead());
    }
}
