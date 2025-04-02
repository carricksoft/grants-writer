/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class CensusConverterTest {

    private CensusConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        LocalDate date = LocalDate.now();
        Census source = new Census();
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        Place place = GetRandomPlace();

        source.setId(id);
        source.setDate(date);
        source.setCensusEntries(censusEntries);
        source.setPlace(place);

        CensusCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(date, target.getDate());
        assertEquals(censusEntries, target.getCensusEntries());
        assertEquals(place, target.getPlace());
    }
}