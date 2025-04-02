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
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class PageFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private PersonFormControllerImpl personController;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    private PersonConverterImpl personConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    PersonCommandValidator personCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        personController = new PersonFormControllerImpl(personServiceMock,
                personCommandConverterMock,
                personConverterMock,
                capitalisationMock,
                personCommandValidatorMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        ArgumentCaptor<PersonCommand> personCommandCaptor = ArgumentCaptor.forClass(PersonCommand.class);
        String first = "first";
        String last = "last";
        PersonCommand personCommand = new PersonCommandImpl();
        personCommand.setFirstName(first);
        personCommand.setLastName(last);
        personCommand.setId(GetRandomLong());
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(capitalisationMock.getCapitalisation(anyString())).thenCallRealMethod();
        when(personServiceMock.savePersonCommand(personCommand)).thenReturn(personCommand);

        personController.saveOrUpdate(personCommand, bindingResultMock, modelMock);

        verify(personServiceMock).savePersonCommand(personCommandCaptor.capture());
        assertEquals("First", personCommandCaptor.getValue().getFirstName());
        assertEquals("Last", personCommandCaptor.getValue().getLastName());
    }


}