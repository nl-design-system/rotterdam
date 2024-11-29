package nl.rotterdam.wicket.docs.behavior_css_rendering;

import nl.rotterdam.design_system.wicket.components.heading.utrecht.UtrechtHeadingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class BehaviorCssPage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add((new Label("testLabel", "Hello I am a label") {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(UtrechtHeadingBehavior.heading(2));
            }
        }));
    }
}
