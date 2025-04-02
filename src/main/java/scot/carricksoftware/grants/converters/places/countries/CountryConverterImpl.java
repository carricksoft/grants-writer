/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.countries;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.domains.places.Country;

@Component
public class CountryConverterImpl implements CountryConverter {

    @Override
    public CountryCommand convert(Country source) {
        CountryCommand target = new CountryCommandImpl();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setRegions(source.getRegions());
        return target;
    }
}
