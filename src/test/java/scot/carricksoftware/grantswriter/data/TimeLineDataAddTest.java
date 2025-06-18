/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TimeLineDataAddTest {


    private TimeLineData timeLineData;

    @Mock
    private TimeLineDateComparator timeLineDateComparatorMock;

    @Mock
    private Place placeMock;

    @Mock
    private Census censusMock;

    @BeforeEach
    void setUp() {
        timeLineData = new TimeLineDataImpl(timeLineDateComparatorMock);
    }

    @Test
    void timeLineAddRefsTest() {
        String censusString = GetRandomString();
        List<CensusEntry> censusEntryList = new ArrayList<>();
        CensusEntry censusEntry = new CensusEntry();

        censusEntry.setCensus(censusMock);
        censusEntryList.add(censusEntry);
        when(censusMock.getCensusDate()).thenReturn(CensusDate.CENSUS_1861);
        when(censusMock.getPlace()).thenReturn(placeMock);
        when(censusMock.toString()).thenReturn(censusString);


        SortedSet<String> refs;
        timeLineData.add(censusEntryList);
        refs = timeLineData.getRefs();

        assertEquals("Census: " + censusString, refs.first());
    }

    @Test
    void timeLineAddCensusEntryTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        CensusEntry censusEntry = new CensusEntry();

        censusEntry.setCensus(censusMock);
        censusEntry.setPersonalOccupation("Work");
        censusEntryList.add(censusEntry);

        when(placeMock.toString()).thenReturn("Edinburgh");

        when(censusMock.getCensusDate()).thenReturn(CensusDate.CENSUS_1861);
        when(censusMock.getPlace()).thenReturn(placeMock);


        timeLineData.add(censusEntryList);

        TreeMap<DMY, List<String>> timeLine = timeLineData.getTimeLine();

        String requiredRecorded = "Recorded as being at Edinburgh";
        String requiredOccupation = "Occupation recorded as Work";
        assertEquals(1, timeLine.size());

        Set<DMY> keys = timeLine.keySet();
        for (DMY key : keys) {
            List<String> values = timeLine.get(key);
            assert (values.contains(requiredRecorded));
            assert (values.contains(requiredOccupation));
        }
    }
}