/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.people.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.data.TimeLineData;
import scot.carricksoftware.grantswriter.domains.census.CensusEntry;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.services.censusentry.CensusEntryService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GatherPlacesCensusTimeLineDataTest {

    private GatherPeopleCensusTimeLineData gatherPeopleCensusTimeLineData;

    @Mock
    CensusEntryService censusEntryServiceMock;
    @Mock
    TimeLineData timeLineDataMock;
    @Mock
    Person personMock;

    @BeforeEach
    void setUp() {
        gatherPeopleCensusTimeLineData = new GatherPeopleCensusTimeLineDataImpl(censusEntryServiceMock, timeLineDataMock);
    }

    @Test
    void gatherTest() {
        List<CensusEntry> censusEntryList = new ArrayList<>();
        when(censusEntryServiceMock.findAllByPerson(personMock)).thenReturn(censusEntryList);
        gatherPeopleCensusTimeLineData.gather(personMock);

        verify(timeLineDataMock).addCensusEntry(censusEntryList);
    }
}