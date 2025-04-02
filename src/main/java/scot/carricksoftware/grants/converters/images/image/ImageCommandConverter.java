/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.image;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.domains.images.Image;

@Component
public interface ImageCommandConverter extends Converter<ImageCommand, Image> {

    @Override
    Image convert(@SuppressWarnings("NullableProblems") @NotNull ImageCommand source);


}
