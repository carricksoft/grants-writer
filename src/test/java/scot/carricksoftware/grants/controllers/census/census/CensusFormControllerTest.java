/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.validators.census.CensusCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusCommand;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusFormControllerTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;


    @Mock
    private CensusConverterImpl censusConverterMock;


    @Mock
    private Model modelMock;

    @Mock
    CensusCommandValidator censusCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandValidatorMock,
                censusConverterMock);
    }

    @Test
    public void getNewCensusTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("census/form", censusController.getNewCensus(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("censusCommand", stringCaptor.getValue());
        assertEquals("CensusCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void censusEditTestEditTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        when(censusServiceMock.findById(id)).thenReturn(census);

        assertEquals("census/form", censusController.censusEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, census);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();

        when(censusServiceMock.findById(id)).thenReturn(census);
        when(censusConverterMock.convert(census)).thenReturn(censusCommand);
        assertEquals("census/form", censusController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, censusCommand);
    }

}