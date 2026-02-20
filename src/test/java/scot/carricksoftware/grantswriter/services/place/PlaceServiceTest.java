/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.repositories.place.PlaceRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(SpringExtension.class)
class PlaceServiceTest {

    private PlaceService service;

    @Mock
    private PlaceRepository placeRepositoryMock;

    @BeforeEach
    void setUp() {
        service = new PlaceServiceImpl(placeRepositoryMock);
    }

    @Test
    public void findAllTest() {
        List<Place> people = new ArrayList<>();
        people.add(GetRandomPlace());
        when(placeRepositoryMock.findAll(any(Sort.class))).thenReturn(people);
        assertEquals(people, service.findAll());
    }
}