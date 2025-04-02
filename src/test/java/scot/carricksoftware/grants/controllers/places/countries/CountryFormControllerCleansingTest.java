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
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.validators.places.CountryCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CountryFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private CountryFormControllerImpl countryController;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private CountryCommandConverterImpl countryCommandConverterMock;

    @Mock
    private CountryConverterImpl countryConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    CountryCommand countryCommandMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    CountryCommandValidator countryCommandValidatorMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock,
                countryCommandValidatorMock);
    }


    @Test
    public void saveOrUpdateCleansingTest() {
        String name = "goat";
        String uName = "Goat";
        when(countryServiceMock.saveCountryCommand(any())).thenReturn(countryCommandMock);
        when(countryCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        countryController.saveOrUpdate(countryCommandMock, bindingResultMock, modelMock);
        verify(countryCommandMock).setName(uName);
    }

    @Test
    public void saveOrUpdateValidationTest() {
        String name = "goat";
        String uName = "Goat";
        when(countryServiceMock.saveCountryCommand(any())).thenReturn(countryCommandMock);
        when(countryCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        countryController.saveOrUpdate(countryCommandMock, bindingResultMock, modelMock);
        verify(countryCommandValidatorMock).validate(countryCommandMock, bindingResultMock);
    }


}