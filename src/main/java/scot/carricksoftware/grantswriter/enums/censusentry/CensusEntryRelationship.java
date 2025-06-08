/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.censusentry;

public enum CensusEntryRelationship {
    @SuppressWarnings("unused") HEAD("Head"),
    @SuppressWarnings("unused") WIFE("Wife"),
    @SuppressWarnings("unused") SON("Son"),
    @SuppressWarnings("unused") DAUGHTER("Daughter"),
    @SuppressWarnings("unused") BROTHER("Brother"),
    @SuppressWarnings("unused") SISTER("Sister"),
    @SuppressWarnings("unused") SON_IN_LAW("Son-in-law"),
    @SuppressWarnings("unused") NIECE("Niece"),
    @SuppressWarnings("unused") COUSIN("Cousin"),
    @SuppressWarnings("unused") BOARDER("Boarder"),
    @SuppressWarnings("unused") VISITOR("Visitor"),
    @SuppressWarnings("unused") SERVANT("Servant");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryRelationship(String label) {
        this.label = label;
    }
}
