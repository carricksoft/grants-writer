/*
 * Copyright (c) 2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.writer.latex.parts.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.services.place.PlaceService;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.headers.PlacesPartHeader;
import scot.carricksoftware.grantswriter.writer.latex.parts.places.sections.PlaceSection;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class PlacesPartWriterTest {

    private PlacesPartWriter placesPartWriter;

    @Mock
    PlacesPartHeader placesPartHeaderMock;
    @Mock
    PlaceService placeServiceMock;
    @Mock
    PlaceSection placeSectionMock;

    @BeforeEach
    void setUp() {
        placesPartWriter = new PlacesPartWriterImpl(placesPartHeaderMock,
                placeServiceMock,
                placeSectionMock);
    }

    @Test
    void placesPartHeaderIsCalledTest() {
        placesPartWriter.write();
        verify(placesPartHeaderMock).write();
    }

    @Test
    void placeSectionIsCalledTest() {
        List<Place> places = new ArrayList<>();
        places.add(GetRandomPlace());
        when(placeServiceMock.findAll()).thenReturn(places);
        placesPartWriter.write();
        verify(placeSectionMock).write(places.get(0));
    }

}