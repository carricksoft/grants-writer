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
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.repositories.places.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomCountry;

@ExtendWith(MockitoExtension.class)
public class CountryServiceFindTest {

    CountryService countryService;

    @Mock
    CountryRepository countryRepositoryMock;

    @Mock
    CountryConverterImpl countryConverterMock;

    @Mock
    CountryCommandConverterImpl countryCommandConverterMock;

    @BeforeEach
    public void setUp() {
        countryService = new CountryServiceImpl(countryRepositoryMock,
                countryConverterMock,
                countryCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<Country> countries = new ArrayList<>();
        countries.add(GetRandomCountry());
        when(countryRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, countryService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        Country country = GetRandomCountry();
        Optional<Country> countryOptional = Optional.of(country);
        when(countryRepositoryMock.findById(id)).thenReturn(countryOptional);
        assertEquals(country, countryService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<Country> empty = Optional.empty();
        when(countryRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(countryService.findById(id));
    }

}