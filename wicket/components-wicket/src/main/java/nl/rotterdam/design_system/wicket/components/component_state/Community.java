package nl.rotterdam.design_system.wicket.components.component_state;

/**
 * Communities die bijdragen. Hebben een Git repository onder de nl-design-system organisatie
 * of zijn anderszins betrokken
 */
public enum Community {
    AMSTERDAM("Gemeente Amsterdam"),
    DEN_HAAG("Gemeente Den Haag"),
    KERNTEAM("Kernteam NL Design System"),
    LUX("Logius"),
    ROTTERDAM("Gemeente Rotterdam"),
    RVO("Rijksdienst voor Ondernemend Nederland"),
    TILBURG("Gemeente Tilburg"),
    UTRECHT("Gemeente Utrecht");

    private final String name;

    Community(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
