/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.countries;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;

@SuppressWarnings("unused")
@Component
public interface CountryConverter extends Converter<Country, CountryCommand> {

    @SuppressWarnings("NullableProblems")
    CountryCommand convert(Country source);
}
