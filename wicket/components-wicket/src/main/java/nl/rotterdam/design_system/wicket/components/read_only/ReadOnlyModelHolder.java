package nl.rotterdam.design_system.wicket.components.read_only;

import org.apache.wicket.model.IModel;

public interface ReadOnlyModelHolder {

    IModel<Boolean> getReadOnlyModel();
}
