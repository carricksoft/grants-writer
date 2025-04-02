/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 09:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorNameTest {

    private CensusEntryCommandValidator validator;

    private CensusEntryCommand censusEntryCommand;


    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusEntryCommandValidator();
        censusEntryCommand = new CensusEntryCommandImpl();
        censusEntryCommand.setCensus(GetRandomCensus());
    }

    @Test
    public void minimumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH]).replace("\0", "x");
        censusEntryCommand.setName(repeated);
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void maximumSizeIsAllowedTest() {
        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH]).replace("\0", "x");
        censusEntryCommand.setName(repeated);
        validator.validate(censusEntryCommand, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void greaterThanMaximumSizeIsRejectedTest() {
        String repeated = new String(new char[ApplicationConstants.MAXIMUM_NAME_LENGTH + 1]).replace("\0", "x");
        censusEntryCommand.setName(repeated);
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("name", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.NAME_IS_TOO_LONG);

    }

    @Test
    public void smallerThanMinimumSizeIsRejectedTest() {
        String repeated = new String(new char[ApplicationConstants.MINIMUM_NAME_LENGTH - 1]).replace("\0", "x");
        censusEntryCommand.setName(repeated);
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("name", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.NAME_IS_TOO_SHORT);
    }


}