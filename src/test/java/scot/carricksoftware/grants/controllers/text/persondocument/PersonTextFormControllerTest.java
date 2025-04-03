/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persondocument;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.controllers.text.persontext.PersonTextFormControllerImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.domains.text.PersonText;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;
import scot.carricksoftware.grants.validators.text.PersonTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.*;


@ExtendWith(MockitoExtension.class)
public class PersonTextFormControllerTest {

    @SuppressWarnings("unused")
    private PersonTextFormControllerImpl personTextController;

    @Mock
    private PersonTextService personTextServiceMock;

    @Mock
    private PersonTextCommandConverterImpl personTextCommandConverterMock;

    @Mock
    private PersonTextConverterImpl personTextConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private PersonTextCommandValidator personTextCommandValidatorMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        personTextController = new PersonTextFormControllerImpl(personTextServiceMock,
                personTextCommandConverterMock,
                personTextConverterMock,
                personTextCommandValidatorMock,
                personServiceMock);
    }

    @Test
    public void getNewPersonTextTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("text/personText/form", personTextController.getNewPersonText(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundPersonTextCommand = false;
        boolean foundPeople = false;


        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("personTextCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("PersonTextCommandImpl")) {
                    foundPersonTextCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }
        assertTrue(foundPersonTextCommand && foundPeople);

    }

    @Test
    public void personTextEditTestEditTest() {
        Long id = GetRandomLong();
        PersonText personText = GetRandomPersonText();
        when(personTextServiceMock.findById(id)).thenReturn(personText);

        assertEquals("text/personText/form", personTextController.personTextEdit(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, personText);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        PersonText personText = GetRandomPersonText();
        PersonTextCommand personTextCommand = GetRandomPersonTextCommand();

        when(personTextServiceMock.findById(id)).thenReturn(personText);
        when(personTextConverterMock.convert(personText)).thenReturn(personTextCommand);
        assertEquals("text/personText/form", personTextController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.PERSON_TEXT_COMMAND, personTextCommand);
    }

}