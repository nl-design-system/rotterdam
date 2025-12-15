package nl.rotterdam.nl_design_system.wicket.components.table;

import java.io.Serializable;

record Person(String name, String email, int age) implements Serializable {
    }
