/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class CensusTest {

    private Census census;

    @Mock
    Place placeMock;

    @Mock
    LocalDate dateMock;

    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getDateTest() {
        assertNull(census.getDate());
    }

    @Test
    public void setDateTest() {
        LocalDate localDate = LocalDate.now();
        census.setDate(localDate);
        assertEquals(localDate, census.getDate());
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
    public void toStringTest() {
        String string = GetRandomString();
        String string2 = GetRandomString();
        census.setPlace(placeMock);
        census.setDate(dateMock);

        when(placeMock.toString()).thenReturn(string);
        when(dateMock.toString()).thenReturn(string2);

        assertEquals(string + ", " + string2, census.toString());
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
