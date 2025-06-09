/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.places.Country;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.domains.places.Region;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


public class TimelineDataAddTest {

    @SuppressWarnings({"unused"})
    private TimelineData timelineData;
    private List<CensusEntry> censusEntryList;
    private Place place;
    private CensusDate censusDate;
    private CensusEntry censusEntry;

    @BeforeEach
    void setUp() {
        timelineData = new TimelineDataImpl();
        Country country = getRandomCountry();
        Region region = getRandomRegion();
        region.setCountry(country);
        place = getRandomPlace();
        place.setRegion(region);

        Census census = new Census();
        census.setPlace(place);
        censusDate = CensusDate.CENSUS_1861;
        census.setCensusDate(CensusDate.CENSUS_1861);

        censusEntry = new CensusEntry();
        censusEntry.setCensus(census);

        censusEntryList = new ArrayList<>();
        censusEntryList.add(censusEntry);

    }

    @SuppressWarnings("unused")
    @Test
    void addTestWhereTest() {
        timelineData.add(censusEntryList);
        SortedMap<String, String> timeline = timelineData.getTimeline();
        String required = "Recorded as being at " + place.toString();

        assertTrue(timeline.containsKey(censusDate.label));
        assertTrue(timeline.containsValue(required));
    }

    @Test
    void addTestOccupationTest() {
        String occupation = GetRandomString();
        censusEntry.setPersonalOccupation(occupation);
        timelineData.add(censusEntryList);
        SortedMap<String, String> timeline = timelineData.getTimeline();
        String required = "Occupation recorded as " + occupation;

        assertTrue(timeline.containsValue(required));
    }

    @Test
    void addTestNoOccupationTest() {
        timelineData.add(censusEntryList);
        SortedMap<String, String> timeline = timelineData.getTimeline();

        assertFalse(timeline.containsValue("Occupation"));
    }

    @Test
    void refsTest() {
        timelineData.add(censusEntryList);
        SortedSet<String> refs = timelineData.getRefs();
        assertTrue(refs.contains(censusEntry.getCensus().toString()));
    }

    private Place getRandomPlace() {
        Place place = new Place();
        place.setName(GetRandomString());
        return place;
    }

    private Region getRandomRegion() {
        Region region = new Region();
        region.setName(GetRandomString());
        return region;
    }

    private Country getRandomCountry() {
        Country country = new Country();
        country.setName(GetRandomString());
        return country;
    }

}