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
import scot.carricksoftware.grantswriter.data.helpers.AddCensusEntry;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class TimeLineDataSetterAddCensusEntryTest {


    private TimeLineData timeLineData;

    @Mock
    private DMY dmyMock;

    @Mock
    private TimeLineDateComparator timeLineDateComparatorMock;

    @Mock
    AddCensusEntry addCensusEntryMock;


    @BeforeEach
    void setUp() {
        timeLineData = new TimeLineDataImpl(addCensusEntryMock, timeLineDateComparatorMock);
    }

    @Test
    void addCensusEntryTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        timeLineData.addCensusEntry(censusEntryList);
        verify(addCensusEntryMock).add(new TreeMap<>(), timeLineData.getRefs(), censusEntryList);
    }



}