/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.placetext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.placeText.PlaceTextConverterImpl;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.text.placetext.PlaceTextService;
import scot.carricksoftware.grants.validators.text.PlaceTextCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceTextFormControllerValidationTest {

    @SuppressWarnings("unused")
    private PlaceTextFormControllerImpl placeTextController;

    @Mock
    private PlaceTextService placeTextServiceMock;

    @Mock
    private PlaceTextCommandConverterImpl placeTextCommandConverterMock;

    @Mock
    private PlaceTextConverterImpl placeTextConverterMock;


    @Mock
    private PlaceTextCommand placeTextCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PlaceTextCommandValidator placeTextCommandValidatorMock;

    @Mock
    private Model modelMock;

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
    public void saveOrUpdateValidationTest() {
        when(placeTextServiceMock.savePlaceTextCommand(any())).thenReturn(placeTextCommandMock);
        placeTextController.saveOrUpdate(placeTextCommandMock, bindingResultMock, modelMock);
        verify(placeTextCommandValidatorMock).validate(placeTextCommandMock, bindingResultMock);
    }


}