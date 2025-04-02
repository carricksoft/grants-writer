/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.PersonImage;

@SuppressWarnings("unused")
@Component
public interface PersonImageConverter extends Converter<PersonImage, PersonImageCommand> {

    @SuppressWarnings("NullableProblems")
    PersonImageCommand convert(PersonImage source);
}
