/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.validators.places.CountryCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CountryFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CountryFormControllerImpl countryController;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private CountryCommandConverterImpl countryCommandConverterMock;

    @Mock
    private CountryConverterImpl countryConverterMock;

    @Mock
    private Capitalisation capitalisationMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    CountryCommandValidator countryCommandValidatorMock;

    private CountryCommand countryCommand;


    @BeforeEach
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock,
                countryCommandValidatorMock);
        countryCommand = new CountryCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        assertEquals("redirect:/country/4/show", countryController.saveOrUpdate(countryCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        countryCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("country/form", countryController.saveOrUpdate(countryCommand, bindingResultMock, modelMock));
    }

    @Test
    public void CleaningTakesPlaceTest() {
        CountryCommand countryCommand = new CountryCommandImpl();
        countryCommand.setId(4L);
        countryCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(countryServiceMock.saveCountryCommand(any(CountryCommand.class))).thenReturn(countryCommand);
        countryController.saveOrUpdate(countryCommand, bindingResultMock, modelMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}