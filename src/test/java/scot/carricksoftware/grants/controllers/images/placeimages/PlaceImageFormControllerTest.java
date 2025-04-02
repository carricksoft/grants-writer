/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomImageValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PlaceImageFormControllerTest {

    @SuppressWarnings("unused")
    private PlaceImageFormControllerImpl placeImageController;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private PlaceImageCommandConverterImpl placeImageCommandConverterMock;

    @Mock
    private PlaceImageConverterImpl placeImageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PlaceImageCommandValidator placeImageCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        placeImageController = new PlaceImageFormControllerImpl(placeImageServiceMock,
                placeImageCommandConverterMock,
                placeImageConverterMock,
                placeImageCommandValidatorMock,
                placeServiceMock);
    }

    @Test
    public void getNewPlaceImageTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("images/placeImage/form", placeImageController.getNewPlaceImage(modelMock));
        verify(modelMock, times(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundPlaceImageCommand = false;
        boolean foundPlaces = false;

        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("placeImageCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("PlaceImageCommandImpl")) {
                    foundPlaceImageCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("places")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPlaces = true;
                }
            }
        }

        assertTrue(foundPlaces && foundPlaceImageCommand);
    }


    @Test
    public void placeImageEditTestEditTest() {
        Long id = GetRandomLong();
        PlaceImage placeImage = GetRandomPlaceImage();
        when(placeImageServiceMock.findById(id)).thenReturn(placeImage);

        assertEquals("images/placeImage/form", placeImageController.placeImageEdit(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, placeImage);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        PlaceImage placeImage = GetRandomPlaceImage();
        PlaceImageCommand placeImageCommand = GetRandomPlaceImageCommand();

        when(placeImageServiceMock.findById(id)).thenReturn(placeImage);
        when(placeImageConverterMock.convert(placeImage)).thenReturn(placeImageCommand);
        assertEquals("images/placeImage/form", placeImageController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.PLACE_IMAGE_COMMAND, placeImageCommand);
    }

}