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
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimeLineDataAddTest {


    private TimeLineData timeLineData;

    @Mock
    private DMY dmyMock;

    @Mock
    private TimeLineDateComparator timeLineDateComparatorMock;

    @Mock
    private Place placeMock;

    @Mock
    private Census censusMock;

    @BeforeEach
    void setUp() {
        timeLineData = new TimeLineDataImpl(dmyMock, timeLineDateComparatorMock);
    }

    @Test
    void timeLineAddRefsTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        CensusEntry censusEntry = new CensusEntry();

        censusEntry.setCensus(censusMock);
        censusEntryList.add(censusEntry);
        when(censusMock.getCensusDate()).thenReturn(CensusDate.CENSUS_1861);
        when(censusMock.getPlace()).thenReturn(placeMock);
        when(censusMock.toString()).thenReturn("Edinburgh");


        SortedSet<String> refs;
        timeLineData.add(censusEntryList);
        refs = timeLineData.getRefs();

        assertEquals("Edinburgh", refs.first());

    }
}