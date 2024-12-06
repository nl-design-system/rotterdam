package nl.rotterdam.wicket.docs.unordered_list;

import java.io.Serializable;

public record Kind(String naam, int geboortejaar, long administratienummer) implements Serializable {
}
