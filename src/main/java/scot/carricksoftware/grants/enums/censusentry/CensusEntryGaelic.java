/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryGaelic {
    @SuppressWarnings("unused") GAELIC("Gaelic"),
    @SuppressWarnings({"unused", "SpellCheckingInspection"}) GAELICANDENGLISH("Gaelic and English");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryGaelic(String label) {
        this.label = label;
    }
}
