/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.services.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.images.PlaceImage;
import scot.carricksoftware.grantswriter.repositories.place.PlaceImageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class PlaceImageServiceTest {

    private PlaceImageService placeImageService;

    @Mock
    private PlaceImageRepository placeImageRepositoryMock;

    @BeforeEach
    void setUp() {
        placeImageService = new PlaceImageServiceImpl(placeImageRepositoryMock);
    }

    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        PlaceImage placeImage = new PlaceImage();
        when(placeImageRepositoryMock.findById(id)).thenReturn(placeImage);
        assertEquals(placeImage, placeImageService.findById(id));
    }

}