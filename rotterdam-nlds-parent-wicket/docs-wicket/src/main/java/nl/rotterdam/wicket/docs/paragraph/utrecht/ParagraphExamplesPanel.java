package nl.rotterdam.wicket.docs.paragraph.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.paragraph.utrecht.UtrechtParagraph;
import nl.rotterdam.nl_design_system.wicket.components.paragraph.utrecht.UtrechtParagraphAppearance;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class ParagraphExamplesPanel extends Panel {

    public ParagraphExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleParagraph() {
        return new UtrechtParagraph("paragraph", "Lorem ipsum dolor sit amet");
    }

    @ComponentExample
    private static Component exampleParagraphLead() {
        return new UtrechtParagraph("paragraphLead", "Lorem ipsum dolor sit amet", UtrechtParagraphAppearance.LEAD);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleParagraph());
        add(exampleParagraphLead());
    }
}
