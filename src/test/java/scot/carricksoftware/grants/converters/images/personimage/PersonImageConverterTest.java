/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.images.personimage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonImageConverterTest {

    private PersonImageConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonImageConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Person person = GetRandomPerson();

        PersonImage source = new PersonImage();

        source.setId(Id);
        source.setPerson(person);

        PersonImageCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(person, target.getPerson());
    }
}