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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.repositories.images.PlaceImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PlaceImageServiceTest {

    PlaceImageService placeImageService;

    @Mock
    PlaceImageRepository placeImageRepositoryMock;

    @Mock
    PlaceImageConverterImpl placeImageConverterImplMock;

    @Mock
    PlaceImageCommandConverterImpl placeImageCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        placeImageService = new PlaceImageServiceImpl(placeImageRepositoryMock,
                placeImageConverterImplMock,
                placeImageCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<PlaceImage> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        placeImageService.deleteById(id);
        verify(placeImageRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(placeImageRepositoryMock.count()).thenReturn(result);
        assertEquals(result, placeImageService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<PlaceImage> result = new ArrayList<>();
        PlaceImage placeImage = GetRandomPlaceImage();
        result.add(placeImage);
        when(pageMock.getContent()).thenReturn(result);
        when(placeImageRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, placeImageService.getPagedPlaceImages(0));
    }




}