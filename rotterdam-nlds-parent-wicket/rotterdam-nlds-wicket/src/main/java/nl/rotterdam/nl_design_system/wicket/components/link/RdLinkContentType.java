package nl.rotterdam.nl_design_system.wicket.components.link;

public enum RdLinkContentType {
    INLINE_BOX("inline-box");

    private final String modifierSuffix;

    RdLinkContentType(String modifierSuffix) {
        this.modifierSuffix = modifierSuffix;
    }

    public String getModifierSuffix() {
        return modifierSuffix;
    }
}
