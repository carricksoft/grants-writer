/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;
import scot.carricksoftware.grants.domains.images.PersonImage;

@Component
public class PersonImageConverterImpl implements PersonImageConverter {

    @Override
    public PersonImageCommand convert(PersonImage source) {
        PersonImageCommand target = new PersonImageCommandImpl();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        return target;
    }
}
