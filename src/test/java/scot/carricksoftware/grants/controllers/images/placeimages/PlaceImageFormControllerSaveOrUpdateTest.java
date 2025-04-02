/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommandImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceImageFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private PlaceImageFormControllerImpl placeImageController;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private PlaceImageCommandConverterImpl placeImageCommandConverterMock;

    @Mock
    private PlaceImageConverterImpl placeImageConverterMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private PlaceImageCommandValidator placeImageCommandValidatorMock;

    private PlaceImageCommand placeImageCommand;


    @BeforeEach
    public void setUp() {
        placeImageController = new PlaceImageFormControllerImpl(placeImageServiceMock,
                placeImageCommandConverterMock,
                placeImageConverterMock,
                placeImageCommandValidatorMock,
                placeServiceMock);
        placeImageCommand = new PlaceImageCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        placeImageCommand.setId(id);
        when(placeImageServiceMock.savePlaceImageCommand(any(PlaceImageCommand.class))).thenReturn(placeImageCommand);
        assertEquals("redirect:/placeImage/4/show", placeImageController.saveOrUpdate(placeImageCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        placeImageCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("images/placeImage/form", placeImageController.saveOrUpdate(placeImageCommand, bindingResultMock, modelMock));
    }

}