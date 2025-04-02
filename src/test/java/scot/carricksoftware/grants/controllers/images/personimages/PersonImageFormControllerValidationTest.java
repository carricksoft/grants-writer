/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.controllers.images.personImages.PersonImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.images.PersonImageCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonImageFormControllerValidationTest {

    @SuppressWarnings("unused")
    private PersonImageFormControllerImpl personImageController;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private PersonImageCommandConverterImpl personImageCommandConverterMock;

    @Mock
    private PersonImageConverterImpl personImageConverterMock;


    @Mock
    private PersonImageCommand personImageCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PersonService personServiceMocK;

    @Mock
    private PersonImageCommandValidator personImageCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        personImageController = new PersonImageFormControllerImpl(personImageServiceMock,
                personImageCommandConverterMock,
                personImageConverterMock,
                personImageCommandValidatorMock,
                personServiceMocK);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(personImageServiceMock.savePersonImageCommand(any())).thenReturn(personImageCommandMock);
        personImageController.saveOrUpdate(personImageCommandMock, bindingResultMock, modelMock);
        verify(personImageCommandValidatorMock).validate(personImageCommandMock, bindingResultMock);
    }


}