/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.text.PersonText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextConverterTest {

    private PersonTextConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonTextConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Person person = GetRandomPerson();

        PersonText source = new PersonText();

        source.setId(Id);
        source.setPerson(person);

        PersonTextCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(person, target.getPerson());
    }
}