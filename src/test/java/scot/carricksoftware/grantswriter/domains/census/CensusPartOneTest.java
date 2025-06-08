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


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCensusRandomEnums.GetRandomCensusDate;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class CensusPartOneTest {

    private Census census;

    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Mock
    private Place placeMock;

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
    public void getCensusEntriesTest() {
        assertTrue(census.getCensusEntries().isEmpty());
    }

    @Test
    public void setCensusEntriesTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        census.setCensusEntries(censusEntries);
        assertEquals(censusEntries, census.getCensusEntries());
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

    @Test
    public void toStringTest() {
        CensusDate censusDate = GetRandomCensusDate();
        String placeString = GetRandomString();
        when(placeMock.toString()).thenReturn(placeString);
        census.setCensusDate(censusDate);
        census.setPlace(placeMock);
        assertEquals(placeString + ", " + censusDate.label, census.toString());
    }


}
