/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.general;

public enum Sex {

    @SuppressWarnings("unused") MALE("Male"),
    FEMALE ("Female");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    Sex(String label) {
        this.label = label;
    }
}
