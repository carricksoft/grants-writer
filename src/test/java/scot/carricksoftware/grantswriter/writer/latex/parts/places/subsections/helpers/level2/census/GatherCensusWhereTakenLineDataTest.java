/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.Census;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;
import static scot.carricksoftware.grantswriter.enums.census.CensusDate.CENSUS_1861;

@ExtendWith(MockitoExtension.class)
class GatherCensusWhereTakenLineDataTest {

    GatherPlaceCensusWhereTakenTimeLineData gatherPlaceCensusWhereTakenTimeLineData;

    @Mock
    private TimeLineData timelineDataMock;

    private List<Census> censusList;

    private TreeMap<DMY, List<String>> timeLine;


    @BeforeEach
    void setUp() {
        gatherPlaceCensusWhereTakenTimeLineData = new GatherPlaceCensusWhereTakenTimeLineDataImpl(this.timelineDataMock);
        censusList = new ArrayList<>();

        Census census = new Census();
        setCensus(census);
        censusList.add(census);
        timeLine = new TreeMap<>();

    }

    private void setCensus(Census census) {
        census.setPlace(GetRandomPlace());
        census.setCensusDate(CENSUS_1861);
    }

    @Test
    void whereTakenTest() {
        when(timelineDataMock.getTimeLine()).thenReturn(timeLine);

        String required = "Census Taken here.";
        gatherPlaceCensusWhereTakenTimeLineData.gather(censusList);
        assertTrue( timeLine.firstEntry().getValue().contains(required));
    }

    @Test
    void AddRefsTest() {
        SortedSet<String> refs = new TreeSet<>();
        when(timelineDataMock.getRefs()).thenReturn(refs);

        gatherPlaceCensusWhereTakenTimeLineData.gather(censusList);
        Census census = censusList.get(0);
        String expected = "Census : " + census.getPlace() + " at " + census.getCensusDate().label;
        assertEquals(expected, refs.first());

    }
}

