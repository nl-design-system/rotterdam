package nl.rotterdam.nl_design_system.wicket.components.component_state;

/**
 * Communities die bijdragen. Hebben een Git repository onder de nl-design-system organisatie
 * of zijn anderszins betrokken
 */
public enum Community {
    /**
     * Gemeente Amsterdam, component prefixed mostly with <em>ams</em>.
     */
    AMSTERDAM("Gemeente Amsterdam"),
    /**
     * Gemeente Den Haag, uses <em>denhaag</em> in code.
     */
    DEN_HAAG("Gemeente Den Haag"),
    /**
     * Team from Binnenlandse Zaken, responsible for Candidate and Hall of Fame components.
     */
    KERNTEAM("Kernteam NL Design System"),
    /**
     * Logius team (creator of DigiD and MijnOverheid). <em>Lux</em>, <em>Logius UX</em> is used in frontend components.
     */
    LOGIUS("Logius"),
    /**
     * Gemeente Rotterdam. Creates <em>RODS</em> (ROtterdam Design System). Wicket components use <em>Rd</em> prefix.
     */
    ROTTERDAM("Gemeente Rotterdam"),
    /**
     * No components used so far.
     */
    RVO("Rijksdienst voor Ondernemend Nederland"),
    /**
     * No components used so far.
     */
    TILBURG("Gemeente Tilburg"),
    /**
     * Prefixed with Utrecht, is predecessor for most Community / Hall of fame components.
     */
    UTRECHT("Gemeente Utrecht");

    private final String name;

    Community(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
