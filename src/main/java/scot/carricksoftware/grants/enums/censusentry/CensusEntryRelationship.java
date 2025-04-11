/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryRelationship {
    @SuppressWarnings("unused") HEAD("Head"),
    @SuppressWarnings("unused") WIFE("Wife"),
    @SuppressWarnings("unused") NIECE("Niece"),
    @SuppressWarnings("unused") COUSIN("Cousin"),
    @SuppressWarnings("unused") BORDER("Border"),
    @SuppressWarnings("unused") SERVANT("Servant");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryRelationship(String label) {
        this.label = label;
    }
}
