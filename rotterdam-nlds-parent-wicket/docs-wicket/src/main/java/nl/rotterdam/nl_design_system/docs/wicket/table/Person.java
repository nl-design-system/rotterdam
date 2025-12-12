package nl.rotterdam.nl_design_system.docs.wicket.table;

import java.io.Serializable;

public record Person(String name, String email, String phone) implements Serializable {
    }