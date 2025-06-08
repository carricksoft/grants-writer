/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.enums.census;

public enum CensusDate {

    CENSUS_1861("07/04/1861"),
    CENSUS_1871("02/04/1871"),
    CENSUS_1881("03/04/1881"),
    CENSUS_1891("05/04/1891"),
    CENSUS_1901("31/03/1901"),
    CENSUS_1911("02/04/1911"),
    CENSUS_1921("19/06/1921"),
    CENSUS_1931("26/04/1931"),
    CENSUS_1939("02/09/1939");


    @SuppressWarnings("unused")
    public final String label;

    @SuppressWarnings("unused")
    CensusDate(String label) {
        this.label = label;
    }
}
