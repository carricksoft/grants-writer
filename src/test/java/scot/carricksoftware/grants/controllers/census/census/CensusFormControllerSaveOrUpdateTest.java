/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.validators.census.CensusCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CensusFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    CensusCommandValidator censusCommandValidatorMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    private CensusCommand censusCommand;

    @BeforeEach
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandValidatorMock,
                censusConverterMock);
        censusCommand = new CensusCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        assertEquals("redirect:/census/4/show", censusController.saveOrUpdate(censusCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("census/form", censusController.saveOrUpdate(censusCommand, bindingResultMock, modelMock));
    }

    @Test
    public void validationTakesPlaceTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        censusController.saveOrUpdate(censusCommand, bindingResultMock, modelMock);
        verify(censusCommandValidatorMock).validate(censusCommand, bindingResultMock);
    }


}