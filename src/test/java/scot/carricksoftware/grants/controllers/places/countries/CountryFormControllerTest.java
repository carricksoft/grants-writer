/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.validators.places.CountryCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountryCommand;


@ExtendWith(MockitoExtension.class)
public class CountryFormControllerTest {

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
    private Model modelMock;

    @Mock
    CountryCommandValidator countryCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        countryController = new CountryFormControllerImpl(countryServiceMock,
                countryCommandConverterMock,
                countryConverterMock,
                capitalisationMock,
                countryCommandValidatorMock);
    }

    @Test
    public void getNewCountryTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("country/form", countryController.getNewCountry(modelMock));
        verify(modelMock).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertEquals("countryCommand", stringCaptor.getValue());
        assertEquals("CountryCommandImpl", objectCaptor.getValue().getClass().getSimpleName());
    }

    @Test
    public void countryEditTestEditTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        when(countryServiceMock.findById(id)).thenReturn(country);

        assertEquals("country/form", countryController.countryEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.COUNTRY_COMMAND, country);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        CountryCommand countryCommand = GetRandomCountryCommand();

        when(countryServiceMock.findById(id)).thenReturn(country);
        when(countryConverterMock.convert(country)).thenReturn(countryCommand);
        assertEquals("country/form", countryController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.COUNTRY_COMMAND, countryCommand);
    }

}