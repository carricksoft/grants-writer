/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonToStringTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
        String firstName = "first";
        String lastName = "last";
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setRecordedYearOfBirth("1953");
    }

    @Test
    void noCertifiedYearOfBirthTest() {
        person.setCertifiedYearOfBirth(null);
        assertEquals("last, first, (1953) -", person.toString());
    }

    @Test
    void certifiedYearOfBirthTest() {
        person.setCertifiedYearOfBirth("1955");
        assertEquals("last, first, 1955 -", person.toString());
    }

}