/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.data.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.DMY;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.enums.census.CensusDate;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
class AddCensusEntryTest {

    private AddCensusEntry addCensusEntry;

    private TreeMap<DMY, List<String>> timeline;

    private List<CensusEntry> censusEntryList;

    private SortedSet<String> refs;

    @Mock
    private Census censusMock;

    @Mock
    private CensusEntry censusEntryMock;



    @BeforeEach
    void setUp() {
        addCensusEntry = new AddCensusEntryImpl();
        refs = new TreeSet<>();
        censusEntryList = new ArrayList<>();
        timeline = new TreeMap<>();
    }

    @Test
    void refsTest() {
        String toString = GetRandomString();
        when(censusEntryMock.getCensus()).thenReturn(censusMock);
        when(censusMock.getCensusDate()).thenReturn(CensusDate.CENSUS_1861);
        when(censusMock.getPlace()).thenReturn(GetRandomPlace());
        when(censusMock.toString()).thenReturn(toString);
        censusEntryList.add(censusEntryMock);
        addCensusEntry.add(timeline, refs, censusEntryList);

        assertEquals("Census: " + toString, refs.first());
    }
}