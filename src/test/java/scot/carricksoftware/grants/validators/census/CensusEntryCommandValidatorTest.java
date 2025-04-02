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
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class CensusEntryCommandValidatorTest {

    private CensusEntryCommandValidator validator;

    private CensusEntryCommand censusEntryCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new CensusEntryCommandValidator();
        censusEntryCommand = new CensusEntryCommandImpl();
    }

    @Test
    public void censusIsNullTest() {
        censusEntryCommand.setPerson(GetRandomPerson());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("census", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_IS_NULL);
    }

    @Test
    public void personAndNameAreNullNameTest() {
        censusEntryCommand.setCensus(GetRandomCensus());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("name", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_NAME_IS_NULL);
    }

    @Test
    public void personAndNameAreNullPersonTest() {
        censusEntryCommand.setCensus(GetRandomCensus());
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("person", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_NAME_IS_NULL);
    }

    @Test
    public void personIsNullAndIsEmptyTest() {
        censusEntryCommand.setCensus(GetRandomCensus());
        censusEntryCommand.setName(ApplicationConstants.EMPTY_STRING);
        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("name", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_NAME_IS_NULL);
    }

    @Test
    public void personAndNameAreGivenNameTest() {
        censusEntryCommand.setCensus(GetRandomCensus());
        censusEntryCommand.setName(GetRandomString());
        censusEntryCommand.setPerson(GetRandomPerson());

        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("name", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_NAME_IS_NOT_NULL);
    }

    @Test
    public void personAndNameAreGivenPersonTest() {
        censusEntryCommand.setCensus(GetRandomCensus());
        censusEntryCommand.setName(GetRandomString());
        censusEntryCommand.setPerson(GetRandomPerson());

        validator.validate(censusEntryCommand, bindingResultMock);
        verify(bindingResultMock).rejectValue("person", ApplicationConstants.EMPTY_STRING, null, ValidationConstants.CENSUS_NAME_IS_NOT_NULL);
    }


}