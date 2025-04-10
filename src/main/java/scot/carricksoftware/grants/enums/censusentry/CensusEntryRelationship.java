/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryRelationship {
    @SuppressWarnings("unused") HEAD("Head"),
    @SuppressWarnings("unused") COUSIN("Cousin");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryRelationship(String label) {
        this.label = label;
    }
}
