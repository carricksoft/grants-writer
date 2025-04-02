/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.placeimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.repositories.images.PlaceImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class PlaceImageServiceFindTest {

    PlaceImageService placeImageService;

    @Mock
    PlaceImageRepository placeImageRepositoryMock;

    @Mock
    PlaceImageConverterImpl placeImageConverterMock;

    @Mock
    PlaceImageCommandConverterImpl placeImageCommandConverterMock;

    @BeforeEach
    public void setUp() {
        placeImageService = new PlaceImageServiceImpl(placeImageRepositoryMock,
                placeImageConverterMock,
                placeImageCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<PlaceImage> countries = new ArrayList<>();
        countries.add(GetRandomPlaceImage());
        when(placeImageRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, placeImageService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        PlaceImage placeImage = GetRandomPlaceImage();
        Optional<PlaceImage> placeImageOptional = Optional.of(placeImage);
        when(placeImageRepositoryMock.findById(id)).thenReturn(placeImageOptional);
        assertEquals(placeImage, placeImageService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<PlaceImage> empty = Optional.empty();
        when(placeImageRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(placeImageService.findById(id));
    }

}