/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.countries;

import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

import java.util.List;

public interface CountryService {

    @SuppressWarnings("unused")
    Country findById(Long id);

    @SuppressWarnings("unused")
    Country save(Country country);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<Country> getPagedCountries(int pageNumber);


    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    CountryCommand saveCountryCommand(CountryCommand countryCommand);


    @SuppressWarnings("unused")
    List<Country> findAll();
}
