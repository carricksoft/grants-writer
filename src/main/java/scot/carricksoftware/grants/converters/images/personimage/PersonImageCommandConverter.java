/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.PersonImage;

@Component
public interface PersonImageCommandConverter extends Converter<PersonImageCommand, PersonImage> {

    @Override
    PersonImage convert(@SuppressWarnings("NullableProblems") @NotNull PersonImageCommand source);


}
