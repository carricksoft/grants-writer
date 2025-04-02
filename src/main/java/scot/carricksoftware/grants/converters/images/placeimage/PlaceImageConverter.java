/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.placeimage;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.domains.images.PlaceImage;

@SuppressWarnings("unused")
@Component
public interface PlaceImageConverter extends Converter<PlaceImage, PlaceImageCommand> {

    @SuppressWarnings("NullableProblems")
    PlaceImageCommand convert(PlaceImage source);
}
