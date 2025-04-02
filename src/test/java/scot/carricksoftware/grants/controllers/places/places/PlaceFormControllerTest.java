/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.PlaceCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.*;


@ExtendWith(MockitoExtension.class)
public class PlaceFormControllerTest {

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
    private Capitalisation capitalisationMock;

    @Mock
    private Model modelMock;

    @Mock
    PlaceCommandValidator placeCommandValidatorMock;


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
    public void getNewPlaceTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("place/form", placeController.getNewPlace(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        boolean foundPlaceCommand = false;
        boolean foundRegions = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("placeCommand")
                    &&
                    objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("PlaceCommandImpl")) {
                foundPlaceCommand = true;
            } else if (stringCaptor.getAllValues().get(i).equals("regions")
                    &&
                    objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                foundRegions = true;
            }
        }
        assertTrue(foundPlaceCommand && foundRegions);

    }

    @Test
    public void placeEditTestEditTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        when(placeServiceMock.findById(id)).thenReturn(place);

        assertEquals("place/form", placeController.placeEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PLACE_COMMAND, place);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        PlaceCommand placeCommand = GetRandomPlaceCommand();

        when(placeServiceMock.findById(id)).thenReturn(place);
        when(placeConverterMock.convert(place)).thenReturn(placeCommand);
        assertEquals("place/form", placeController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PLACE_COMMAND, placeCommand);
    }

}