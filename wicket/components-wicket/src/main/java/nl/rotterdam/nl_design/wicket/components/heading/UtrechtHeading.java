package nl.rotterdam.nl_design.wicket.components.heading;

import css.NlDesignSystemCssReferences;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

public class UtrechtHeading extends Label  {

    public UtrechtHeading(String id) {
        super(id);
    }

    public UtrechtHeading(String id, Serializable label) {
        super(id, label);
    }

    public UtrechtHeading(String id, IModel<?> model) {
        super(id, model);
    }

    public UtrechtHeading level(int level) {
        add(UtrechtHeadingBehavior.heading(level));
        return this;
    }

}
