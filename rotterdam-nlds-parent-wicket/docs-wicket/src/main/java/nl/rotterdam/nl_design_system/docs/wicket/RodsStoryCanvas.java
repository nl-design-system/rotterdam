package nl.rotterdam.nl_design_system.docs.wicket;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class RodsStoryCanvas  {

    public static final JavaScriptReferenceHeaderItem RODS_STORY_CANVAS_JS_HEADER_ITEM;
    
    static {
        RODS_STORY_CANVAS_JS_HEADER_ITEM = JavaScriptHeaderItem.forReference(
            new JavaScriptResourceReference(RodsStoryCanvas.class, "rods-story-canvas.js")
        );
        RODS_STORY_CANVAS_JS_HEADER_ITEM.setType(JavaScriptReferenceType.MODULE);
    }
}
