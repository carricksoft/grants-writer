/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.images.PlaceImage;

@Component
public interface PlaceImageCommandConverter extends Converter<PlaceImageCommand,PlaceImage> {

    @Override
    PlaceImage convert(@SuppressWarnings("NullableProblems") @NotNull PlaceImageCommand source);


}
