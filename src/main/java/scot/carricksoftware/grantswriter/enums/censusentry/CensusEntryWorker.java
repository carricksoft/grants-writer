/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.censusentry;

public enum CensusEntryWorker {
    @SuppressWarnings("unused") WORKER("Worker"),
    @SuppressWarnings("unused") EMPLOYER("Employer"),
    @SuppressWarnings("unused") EMPLOYED("Employed"),
    @SuppressWarnings("unused") NEITHER_EMPLOYED_OR_EMPLOYER("Neither Employed or Employer"),
    OWN_ACCOUNT("Own Account");

    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusEntryWorker(String label) {
        this.label = label;
    }
}
