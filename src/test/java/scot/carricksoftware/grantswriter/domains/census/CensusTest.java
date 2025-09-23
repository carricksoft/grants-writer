/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class CensusTest {

    private Census census;

    @Mock private Place placeMock;

    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getIdTest() {
        assertNull(census.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        census.setId(id);
        assertEquals(id, census.getId());
    }

    @Test
    public void getCensusDateTest() {
        assertNull(census.getCensusDate());
    }

    @Test
    public void setCensusDateTest() {
        CensusDate censusDate = CensusDate.CENSUS_1861;
        census.setCensusDate(censusDate);
        assertEquals(censusDate, census.getCensusDate());
    }

    @Test
    public void toStringTest() {
        CensusDate censusDate = GetRandomCensusDate();
        String placeString = GetRandomString();
        when(placeMock.toString()).thenReturn(placeString);
        census.setCensusDate(censusDate);
        census.setPlace(placeMock);
        assertEquals(placeString + ", " + censusDate.label, census.toString());
    }

    @Test
    public void getPlaceTest() {
        assertNull(census.getPlace());
    }

    @Test
    public void setPlaceTest() {
        Place place = GetRandomPlace();
        census.setPlace(place);
        assertEquals(place, census.getPlace());
    }

}
