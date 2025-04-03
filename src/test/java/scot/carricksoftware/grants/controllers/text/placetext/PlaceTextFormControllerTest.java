/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PlaceText;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;
import scot.carricksoftware.grants.validators.text.PlaceTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.*;


@ExtendWith(MockitoExtension.class)
public class PlaceTextFormControllerTest {

    @SuppressWarnings("unused")
    private PlaceTextFormControllerImpl placeTextController;

    @Mock
    private PlaceTextService placeTextServiceMock;

    @Mock
    private PlaceTextCommandConverterImpl placeTextCommandConverterMock;

    @Mock
    private PlaceTextConverterImpl placeTextConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private PlaceTextCommandValidator placeTextCommandValidatorMock;

    @Mock
    private PlaceService placeServiceMock;


    @BeforeEach
    public void setUp() {
        placeTextController = new PlaceTextFormControllerImpl(placeTextServiceMock,
                placeTextCommandConverterMock,
                placeTextConverterMock,
                placeTextCommandValidatorMock,
                placeServiceMock);
    }

    @Test
    public void getNewPlaceTextTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("text/placeText/form", placeTextController.getNewPlaceText(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundPlaceTextCommand = false;
        boolean foundPeople = false;


        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("placeTextCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("PlaceTextCommandImpl")) {
                    foundPlaceTextCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("places")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }
        assertTrue(foundPlaceTextCommand && foundPeople);

    }

    @Test
    public void placeTextEditTestEditTest() {
        Long id = GetRandomLong();
        PlaceText placeText = GetRandomPlaceText();
        when(placeTextServiceMock.findById(id)).thenReturn(placeText);

        assertEquals("text/placeText/form", placeTextController.placeTextEdit(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, placeText);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        PlaceText placeText = GetRandomPlaceText();
        PlaceTextCommand placeTextCommand = GetRandomPlaceTextCommand();

        when(placeTextServiceMock.findById(id)).thenReturn(placeText);
        when(placeTextConverterMock.convert(placeText)).thenReturn(placeTextCommand);
        assertEquals("text/placeText/form", placeTextController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.PLACE_TEXT_COMMAND, placeTextCommand);
    }

}