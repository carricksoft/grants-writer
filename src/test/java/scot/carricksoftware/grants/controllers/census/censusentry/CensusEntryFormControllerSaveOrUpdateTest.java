/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.census.CensusEntryCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CensusEntryFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CensusEntryFormControllerImpl censusEntryController;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    CensusEntryCommandValidator censusEntryCommandValidatorMock;

    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    CensusEntryCommand censusEntryCommand;

    @BeforeEach
    public void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusEntryCommandValidatorMock,
                censusEntryConverterMock,
                capitalisationMock,
                personServiceMock,
                censusServiceMock);
        censusEntryCommand = new CensusEntryCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);
        assertEquals("redirect:/censusEntry/4/show", censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("censusentry/form", censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock, modelMock));
    }

    @Test
    public void validationTakesPlaceTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);
        censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock, modelMock);
        verify(censusEntryCommandValidatorMock).validate(censusEntryCommand, bindingResultMock);
    }

    @Test
    public void capitalisationTakesPlaceTest() {
        Long id = 4L;
        String name = "test";
        String uname = "Test";
        censusEntryCommand.setId(id);
        censusEntryCommand.setName(name);
        when(capitalisationMock.getCapitalisation(anyString())).thenReturn(uname);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);

        censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock, modelMock);

        verify(capitalisationMock).getCapitalisation(name);

        assertEquals(uname, censusEntryCommand.getName());

    }


}