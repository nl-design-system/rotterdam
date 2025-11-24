package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;
import org.danekja.java.util.function.serializable.SerializableSupplier;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

public record RdSideNavRecord(
    @Nullable SerializableSupplier<? extends Behavior> iconBehaviorSupplier,
    String label,
    Class<? extends WebPage> page,
    @Nullable
    PageParameters parameters,
    @Nullable
    Long numberBadge,
    @Nullable // currently not used; is defined in https://nldesignsystem.nl/number-badge/, not in utrecht impl, but is defined (but unused) in Java
    String numberBadgeLabel
) implements Serializable {
    public RdSideNavRecord {
        if (!Strings.isEmpty(numberBadgeLabel)) {
            if (numberBadge == null) {
                throw new IllegalArgumentException("numberBadge is required if numberBadgeLabel is set");
            }
        }
    }
}
