/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.PlaceCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    PlaceCommandValidator placeCommandValidatorMock;

    private PlaceCommand placeCommand;


    @BeforeEach
    public void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock,
                placeCommandValidatorMock,
                regionServiceMock);
        placeCommand = new PlaceCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        placeCommand.setId(id);
        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);
        assertEquals("redirect:/place/4/show", placeController.saveOrUpdate(placeCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        placeCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("place/form", placeController.saveOrUpdate(placeCommand, bindingResultMock, modelMock));
    }

    @Test
    public void CleaningTakesPlaceTest() {
        PlaceCommand placeCommand = new PlaceCommandImpl();
        placeCommand.setId(4L);
        placeCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);
        placeController.saveOrUpdate(placeCommand, bindingResultMock, modelMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}