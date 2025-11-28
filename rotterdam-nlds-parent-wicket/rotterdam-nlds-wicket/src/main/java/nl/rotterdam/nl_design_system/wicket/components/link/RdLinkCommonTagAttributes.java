package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.markup.ComponentTag;
import org.jspecify.annotations.Nullable;

class RdLinkCommonTagAttributes {
    static void addAttributes(ComponentTag tag, boolean isPlaceholder, @Nullable  RdLinkContentType contentType) {
        if (isPlaceholder) {
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
        }

        new TokenSetBuilder()
            .append(isPlaceholder, "nl-link--placeholder")
            .append(contentType != null, () -> "nl-link--" + contentType.getModifierSuffix())
            .use(classes -> tag.append("class", classes, " "));
    }
}
