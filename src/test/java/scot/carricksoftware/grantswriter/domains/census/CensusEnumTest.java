/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.enums.census.CensusBoundaryType;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCensusRandomEnums.GetRandomCensusBoundaryType;
import static scot.carricksoftware.grantswriter.GenerateCensusRandomEnums.GetRandomCensusDate;

@ExtendWith(MockitoExtension.class)
class CensusEnumTest {

    private Census census;

    @BeforeEach
    void setUp() {
        census = new Census();
    }

    @Test
    void getBoundaryType() {
        assertNull(census.getBoundaryType());
    }

    @Test
    void setBoundaryTypeTest() {
        CensusBoundaryType boundaryType = GetRandomCensusBoundaryType();
        census.setBoundaryType(boundaryType);
        assertEquals(boundaryType, census.getBoundaryType());
    }

    @Test
    public void getCensusDateTest() {
        assertNull(census.getCensusDate());
    }

    @Test
    public void setCensusDateTest() {
        CensusDate date = GetRandomCensusDate();
        census.setCensusDate(date);
        assertEquals(date, census.getCensusDate());
    }

}