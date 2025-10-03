/*-
 * #%L
 * parkeren-web-nieuw
 * ==
 * Copyright (C) 2010 - 2025 Gemeente Rotterdam, Nederland
 * ==
 * All rights reserved. Without explicit written consent beforehand of the gemeente Rotterdam nothing of this software
 * and source code may be reproduced, adapted, distributed, and/or communicated to the public, except in case of a
 * statutory limitation of copyright.
 * #L%
 */
package nl.rotterdam.design_system.wicket.components.wcag_input;

/**
 * Het doel van een input veld. Dit helpt onder andere voor screenreaders om het doel van een input uit te leggen en
 * voor autocomplete functionaliteit.
 * <p>
 * Zie https://www.w3.org/TR/WCAG21/#input-purposes voor de complete lijst van toegestane waarden.
 *
 */
public enum WcagInputPurpose {

    GIVEN_NAME("given-name"),

    FAMILY_NAME("family-name"),

    /* full name */
    NAME("name"),

    EMAIL("email"),
    TEL_NATIONAL("tel-national"),
    /** Als voorbeeld wordt creditcard gegeven, maar dit lijkt geen harde eis te zijn */
    CC_NUMBER("cc-number");

    private final String inputPurpose;

    WcagInputPurpose(String inputPurpose) {
        this.inputPurpose = inputPurpose;
    }

    public String getInputPurpose() {
        return inputPurpose;
    }
}
