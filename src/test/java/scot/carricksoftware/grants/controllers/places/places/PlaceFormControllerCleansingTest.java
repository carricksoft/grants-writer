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
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.PlaceCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    PlaceCommand placeCommandMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    PlaceCommandValidator placeCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock,
                placeCommandValidatorMock,
                regionServiceMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(placeServiceMock.savePlaceCommand(any())).thenReturn(placeCommandMock);
        when(placeCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        placeController.saveOrUpdate(placeCommandMock, bindingResultMock, modelMock);
        verify(placeCommandMock).setName(uName);
    }

    @Test
    public void saveOrUpdateValidationTest() {
        String name = "goat";
        String uName = "Goat";
        when(placeServiceMock.savePlaceCommand(any())).thenReturn(placeCommandMock);
        when(placeCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        placeController.saveOrUpdate(placeCommandMock, bindingResultMock, modelMock);
        verify(placeCommandValidatorMock).validate(placeCommandMock, bindingResultMock);
    }


}