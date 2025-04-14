/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.censusentry;

public enum CensusEntryWorker {
    @SuppressWarnings("unused") WORKER("Worker"),
    @SuppressWarnings("unused") EMPLOYER("Widower"),
    @SuppressWarnings("unused") OWN_ACCOUNT("Own Account"),;

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryWorker(String label) {
        this.label = label;
    }
}
