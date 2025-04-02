/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.places;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class PlaceServiceSaveTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    @Mock
    PlaceConverterImpl placeConverterImplMock;

    @Mock
    PlaceCommandConverterImpl placeCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock,
                placeConverterImplMock,
                placeCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        Place place = new Place();
        place.setName(GetRandomString());

        when(placeRepositoryMock.save(place)).thenReturn(place);

        assertEquals(place, placeService.save(place));
    }

    @Test
    public void savePlaceCommandTest() {
        Place place = GetRandomPlace();
        PlaceCommand placeCommand = new PlaceCommandImpl();
        when(placeCommandConverterImplMock.convert(placeCommand)).thenReturn(place);
        when(placeRepositoryMock.save(place)).thenReturn(place);
        when(placeConverterImplMock.convert((place))).thenReturn(placeCommand);

        assertEquals(placeCommand, placeService.savePlaceCommand(placeCommand));
    }


}