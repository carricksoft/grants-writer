/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.countries;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;


@ExtendWith(MockitoExtension.class)
public class CountryServiceSaveTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterImplMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        countryService = new CountryServiceImpl(countryRepositoryMock,
                countryConverterImplMock,
                countryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        Country country = new Country();
        country.setName(GetRandomString());

        when(countryRepositoryMock.save(country)).thenReturn(country);

        assertEquals(country, countryService.save(country));
    }

    @Test
    public void saveCountryCommandTest() {
        Country country = GetRandomCountry();
        CountryCommand countryCommand = new CountryCommandImpl();
        when(countryCommandConverterImplMock.convert(countryCommand)).thenReturn(country);
        when(countryRepositoryMock.save(country)).thenReturn(country);
        when(countryConverterImplMock.convert((country))).thenReturn(countryCommand);

        assertEquals(countryCommand, countryService.saveCountryCommand(countryCommand));
    }


}