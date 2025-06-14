/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.LinkedMultiValueMap;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class TimelineDataAddTest {

    @SuppressWarnings({"unused"})
    private TimelineData timelineData;
    private List<CensusEntry> censusEntryList;
    private CensusEntry censusEntry;
    Census census;

    @BeforeEach
    void setUp() {
        timelineData = new TimelineDataImpl();
        Place place = GetRandomPlace();

        census = new Census();
        census.setPlace(place);
        census.setCensusDate(CensusDate.CENSUS_1861);

        censusEntry = new CensusEntry();
        censusEntry.setCensus(census);

        censusEntryList = new ArrayList<>();
        censusEntryList.add(censusEntry);
    }

    @SuppressWarnings("unused")
    private boolean isFound(LinkedMultiValueMap<String, String> timeline, String required) {
        boolean found = false;
        Collection<List <String>> test = timeline.values();

        for (List<String> list : test) {
            for (String s : list) {
                if (s.equals(required)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    @Test
    void refsTest() {
        timelineData.add(censusEntryList);
        SortedSet<String> refs = timelineData.getRefs();
        assertTrue(refs.contains(censusEntry.getCensus().toString()));
    }



}