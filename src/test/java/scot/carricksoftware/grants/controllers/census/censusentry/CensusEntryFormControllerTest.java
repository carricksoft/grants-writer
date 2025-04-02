/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.census.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.census.CensusEntryCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusEntryFormControllerTest {

    @SuppressWarnings("unused")
    private CensusEntryFormControllerImpl censusEntryController;

    @Mock
    private CensusEntryService censusEntryServiceMock;


    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;


    @Mock
    private Model modelMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private CensusEntryCommandValidator censusEntryCommandValidatorMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    private PersonService personServiceMock;


    @BeforeEach
    public void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusEntryCommandValidatorMock,
                censusEntryConverterMock,
                capitalisationMock,
                personServiceMock,
                censusServiceMock);
    }

    @Test
    public void getNewCensusEntryTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("censusentry/form", censusEntryController.getNewCensusEntry(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundCensusEntryCommand = false;
        boolean foundPeople = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("censusEntryCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("CensusEntryCommandImpl")) {
                    foundCensusEntryCommand = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("people")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPeople = true;
                }
            }
        }

        assertTrue(foundCensusEntryCommand && foundPeople);

    }

    @Test
    public void censusEntryEditTest() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        when(censusEntryServiceMock.findById(id)).thenReturn(censusEntry);

        assertEquals("censusentry/form", censusEntryController.censusEntryEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, censusEntry);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = GetRandomCensusEntryCommand();

        when(censusEntryServiceMock.findById(id)).thenReturn(censusEntry);
        when(censusEntryConverterMock.convert(censusEntry)).thenReturn(censusEntryCommand);
        assertEquals("censusentry/form", censusEntryController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, censusEntryCommand);
    }

}