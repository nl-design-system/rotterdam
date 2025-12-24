package nl.rotterdam.nl_design_system.docs.wicket.table;

import java.io.Serializable;

public record Person(String name, String email, String phone, String street, int houseNumber) implements Serializable {
}