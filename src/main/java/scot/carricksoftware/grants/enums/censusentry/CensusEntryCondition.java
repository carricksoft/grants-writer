/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryCondition {
    @SuppressWarnings("unused") WIDOW("Widow"),
    @SuppressWarnings("unused") WIDOWER("Widower"),
    @SuppressWarnings("unused") MARRIED("Married"),
    @SuppressWarnings("unused") SINGLE("Single");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryCondition(String label) {
        this.label = label;
    }
}
