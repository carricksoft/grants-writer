/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grantswriter;

import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;


@SuppressWarnings("unused")
public class GenerateRandomCensusValues {

    @SuppressWarnings("unused")
    public static Census GetRandomCensus() {
        Census census = new Census();
        census.setId(GetRandomLong());
        return census;
    }


    public static CensusEntry GetRandomCensusEntry() {
        CensusEntry censusEntry = new CensusEntry();
        censusEntry.setId(GetRandomLong());
        censusEntry.setName(GetRandomString());
        return censusEntry;
    }


}
