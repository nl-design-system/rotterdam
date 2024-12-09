package nl.rotterdam.wicket.docs;

import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;

public class ESMReferenceHeaderItem extends JavaScriptReferenceHeaderItem {

    public ESMReferenceHeaderItem(ResourceReference reference, PageParameters pageParameters, String id) {
        super(reference, pageParameters, id);
        this.setType(JavaScriptReferenceType.MODULE);
    }
}
