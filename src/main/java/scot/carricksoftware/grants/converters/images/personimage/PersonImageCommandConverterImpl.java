/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.PersonImage;

@Component
public class PersonImageCommandConverterImpl implements PersonImageCommandConverter {

    @Override
    public PersonImage convert(@NotNull PersonImageCommand source) {
        PersonImage target = new PersonImage();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        return target;
    }


}
