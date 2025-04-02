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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


@ExtendWith(MockitoExtension.class)
public class PlaceServiceTest {

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

    @Mock
    Page<Place> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        placeService.deleteById(id);
        verify(placeRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(placeRepositoryMock.count()).thenReturn(result);
        assertEquals(result, placeService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<Place> result = new ArrayList<>();
        Place place = GetRandomPlace();
        result.add(place);
        when(pageMock.getContent()).thenReturn(result);
        when(placeRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, placeService.getPagedPlaces(0));
    }


}