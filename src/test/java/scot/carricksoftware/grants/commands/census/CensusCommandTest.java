/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class CensusCommandTest {

    private CensusCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    void getDateTest() {
        assertNull(command.getDate());
    }

    @Test
    void setDateTest() {
        LocalDate date = LocalDate.now();
        command.setDate(date);
        assertEquals(date, command.getDate());
    }

    @Test
    void getCensusEntriesTest() {
        assertTrue(command.getCensusEntries().isEmpty());
    }

    @Test
    void setCensusEntriesTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        command.setCensusEntries(censusEntries);
        assertEquals(censusEntries, command.getCensusEntries());
    }

    @Test
    public void getPlaceTest() {
        assertNull(command.getPlace());
    }

    @Test
    public void setPlaceTest() {
        Place place = GetRandomPlace();
        command.setPlace(place);
        assertEquals(place, command.getPlace());
    }
}