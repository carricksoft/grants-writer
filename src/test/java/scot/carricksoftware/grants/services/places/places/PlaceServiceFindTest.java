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
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class PlaceServiceFindTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    @Mock
    PlaceConverterImpl placeConverterMock;

    @Mock
    PlaceCommandConverterImpl placeCommandConverterMock;

    @BeforeEach
    public void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock,
                placeConverterMock,
                placeCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Place> countries = new ArrayList<>();
        countries.add(GetRandomPlace());
        when(placeRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, placeService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        Optional<Place> placeOptional = Optional.of(place);
        when(placeRepositoryMock.findById(id)).thenReturn(placeOptional);
        assertEquals(place, placeService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Place> empty = Optional.empty();
        when(placeRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(placeService.findById(id));
    }

}