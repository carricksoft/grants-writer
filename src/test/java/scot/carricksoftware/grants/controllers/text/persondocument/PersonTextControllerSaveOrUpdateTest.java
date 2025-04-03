/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.persondocument;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.controllers.text.persontext.PersonTextFormControllerImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.persontext.PersonTextConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.text.persontext.PersonTextService;
import scot.carricksoftware.grants.validators.text.PersonTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonTextControllerSaveOrUpdateTest {

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
    private BindingResult bindingResultMock;

    @Mock
    private PersonTextCommandValidator personTextCommandValidatorMock;

    @Mock
    private PersonService personServiceMock;

    private PersonTextCommand personTextCommand;


    @BeforeEach
    public void setUp() {
        personTextController = new PersonTextFormControllerImpl(personTextServiceMock,
                personTextCommandConverterMock,
                personTextConverterMock,
                personTextCommandValidatorMock,
                personServiceMock);
        personTextCommand = new PersonTextCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        personTextCommand.setId(id);
        when(personTextServiceMock.savePersonTextCommand(any(PersonTextCommand.class))).thenReturn(personTextCommand);
        assertEquals("redirect:/personText/4/show", personTextController.saveOrUpdate(personTextCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        personTextCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("text/personText/form", personTextController.saveOrUpdate(personTextCommand, bindingResultMock, modelMock));
    }

}