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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.repositories.images.PlaceImageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomImageValues.GetRandomPlaceImage;


@ExtendWith(MockitoExtension.class)
public class PlaceImageServiceSaveTest {

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


    @Test
    public void saveTest() {
        PlaceImage placeImage = new PlaceImage();

        when(placeImageRepositoryMock.save(placeImage)).thenReturn(placeImage);

        assertEquals(placeImage, placeImageService.save(placeImage));
    }

    @Test
    public void savePlaceImageCommandTest() {
        PlaceImage placeImage = GetRandomPlaceImage();
        PlaceImageCommand placeImageCommand = new PlaceImageCommandImpl();
        when(placeImageCommandConverterImplMock.convert(placeImageCommand)).thenReturn(placeImage);
        when(placeImageRepositoryMock.save(placeImage)).thenReturn(placeImage);
        when(placeImageConverterImplMock.convert((placeImage))).thenReturn(placeImageCommand);

        assertEquals(placeImageCommand, placeImageService.savePlaceImageCommand(placeImageCommand));
    }


}