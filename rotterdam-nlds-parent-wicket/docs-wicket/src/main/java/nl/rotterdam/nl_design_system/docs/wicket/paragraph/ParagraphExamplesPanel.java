package nl.rotterdam.nl_design_system.docs.wicket.paragraph;

import nl.rotterdam.nl_design_system.wicket.components.paragraph.RdParagraphBorder;
import nl.rotterdam.nl_design_system.wicket.components.paragraph.RdParagraphAppearance;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.Component;

public class ParagraphExamplesPanel extends ExamplesPanel {

    public ParagraphExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdParagraphBorder.class;
    }

    @ComponentExample
    private static Component exampleParagraph() {
        return new RdParagraphBorder("paragraph");
    }

    @ComponentExample
    private static Component exampleParagraphLead() {
        return new RdParagraphBorder("paragraphLead", RdParagraphAppearance.LEAD);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleParagraph());
        add(exampleParagraphLead());
    }
}
