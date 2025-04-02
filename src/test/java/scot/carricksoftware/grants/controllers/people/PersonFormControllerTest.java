/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPersonCommand;


@ExtendWith(MockitoExtension.class)
public class PersonFormControllerTest {

    @SuppressWarnings("unused")
    private PersonFormControllerImpl personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    private Model modelMock;

    @Mock
    PersonCommandValidator personCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock,
                personCommandValidatorMock);
    }

    @Test
    public void getNewPersonTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("person/form", personController.getNewPerson(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("personCommand", stringCaptor.getValue());
        assertEquals("PersonCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void personEditTestEditTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        when(personServiceMock.findById(id)).thenReturn(person);

        assertEquals("person/form", personController.personEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PERSON_COMMAND, person);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        PersonCommand personCommand = GetRandomPersonCommand();

        when(personServiceMock.findById(id)).thenReturn(person);
        when(personConverterMock.convert(person)).thenReturn(personCommand);
        assertEquals("person/form", personController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PERSON_COMMAND, personCommand);
    }

}