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
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;
import scot.carricksoftware.grants.controllers.images.personImages.PersonImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.images.PersonImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonImageFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private PersonImageFormControllerImpl personImageController;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private PersonImageCommandConverterImpl personImageCommandConverterMock;

    @Mock
    private PersonImageConverterImpl personImageConverterMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private PersonImageCommandValidator personImageCommandValidatorMock;

    private PersonImageCommand personImageCommand;


    @BeforeEach
    public void setUp() {
        personImageController = new PersonImageFormControllerImpl(personImageServiceMock,
                personImageCommandConverterMock,
                personImageConverterMock,
                personImageCommandValidatorMock,
                personServiceMock);
        personImageCommand = new PersonImageCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        personImageCommand.setId(id);
        when(personImageServiceMock.savePersonImageCommand(any(PersonImageCommand.class))).thenReturn(personImageCommand);
        assertEquals("redirect:/personImage/4/show", personImageController.saveOrUpdate(personImageCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        personImageCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("images/personImage/form", personImageController.saveOrUpdate(personImageCommand, bindingResultMock, modelMock));
    }

}