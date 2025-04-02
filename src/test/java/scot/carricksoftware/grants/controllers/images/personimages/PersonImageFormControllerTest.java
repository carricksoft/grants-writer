/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.personimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.controllers.images.personImages.PersonImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.personimage.PersonImageConverterImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.images.PersonImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomImageValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PersonImageFormControllerTest {

    @SuppressWarnings("unused")
    private PersonImageFormControllerImpl personImageController;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private PersonImageCommandConverterImpl personImageCommandConverterMock;

    @Mock
    private PersonImageConverterImpl personImageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private PersonImageCommandValidator personImageCommandValidatorMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        personImageController = new PersonImageFormControllerImpl(personImageServiceMock,
                personImageCommandConverterMock,
                personImageConverterMock,
                personImageCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewPersonImageTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("images/personImage/form", personImageController.getNewPersonImage(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundPersonImageCommand = false;
        boolean foundPeople = false;

        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("personImageCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("PersonImageCommandImpl")) {
                    foundPersonImageCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }
        assertTrue(foundPersonImageCommand && foundPeople);
    }

    @Test
    public void personImageEditTestEditTest() {
        Long id = GetRandomLong();
        PersonImage personImage = GetRandomPersonImage();
        when(personImageServiceMock.findById(id)).thenReturn(personImage);

        assertEquals("images/personImage/form", personImageController.personImageEdit(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, personImage);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        PersonImage personImage = GetRandomPersonImage();
        PersonImageCommand personImageCommand = GetRandomPersonImageCommand();

        when(personImageServiceMock.findById(id)).thenReturn(personImage);
        when(personImageConverterMock.convert(personImage)).thenReturn(personImageCommand);
        assertEquals("images/personImage/form", personImageController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.PERSON_IMAGE_COMMAND, personImageCommand);
    }

}