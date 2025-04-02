/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.places;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

@SuppressWarnings("unused")
@Component
public interface PlaceConverter extends Converter<Place, PlaceCommand> {

    @SuppressWarnings("NullableProblems")
    PlaceCommand convert(Place source);
}
