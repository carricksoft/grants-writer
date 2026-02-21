/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.census.Census;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.census.CensusService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.subsections.helpers.level2.census.GatherPlaceCensusWhereTakenTimeLineData;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class GatherPlaceCensusTimeLineDataTest {

    private GatherPlaceCensusTimeLineData gatherPlaceCensusTimeLineData;

    @Mock
    private CensusService censusServiceMock;
    @Mock
    private GatherPlaceCensusWhereTakenTimeLineData gatherPlaceCensusWhereTakenLineDataMock;

    List<Census> census;
    Place place;

    @BeforeEach
    void setUp() {
        gatherPlaceCensusTimeLineData = new GatherPlaceCensusTimeLineDataImpl(
                censusServiceMock,
                gatherPlaceCensusWhereTakenLineDataMock);
        census = new ArrayList<>();

        place = GetRandomPlace();
    }

    @Test
    void emptyTest() {
        when(censusServiceMock.findAllByPlace(place)).thenReturn(census);
        gatherPlaceCensusTimeLineData.gather(place);
        verifyNoInteractions(gatherPlaceCensusWhereTakenLineDataMock);
    }

    @Test
    void nonEmptyTest() {
        census.add(new Census());
        when(censusServiceMock.findAllByPlace(place)).thenReturn(census);
        gatherPlaceCensusTimeLineData.gather(place);
        verify(gatherPlaceCensusWhereTakenLineDataMock).gather(census);
    }

}