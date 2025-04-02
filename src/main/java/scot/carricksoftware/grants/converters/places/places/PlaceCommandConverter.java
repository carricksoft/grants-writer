/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.places;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public interface PlaceCommandConverter extends Converter<PlaceCommand, Place> {

    @Override
    Place convert(@SuppressWarnings("NullableProblems") @NotNull PlaceCommand source);


}
