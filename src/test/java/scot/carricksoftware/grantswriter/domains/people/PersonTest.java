/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getFirstNameTest() {
        assertNull(person.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        String firstName = GetRandomString();
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void getLastNameTest() {
        assertNull(person.getLastName());
    }

    @Test
    void setLastNameTest() {
        String lastName = GetRandomString();
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }

    @Test
    void getRecordedYearOfBirthTest() {
        assertNull(person.getRecordedYearOfBirth());
    }

    @Test
    void setRecordedYearOfBirthTest() {
        String recordedYearOfBirth = GetRandomString();
        person.setRecordedYearOfBirth(recordedYearOfBirth);
        assertEquals(recordedYearOfBirth, person.getRecordedYearOfBirth());
    }

    @Test
    void getCertifiedYearOfBirthTest() {
        assertNull(person.getCertifiedYearOfBirth());
    }

    @Test
    void setCertifiedYearOfBirthTest() {
        String certifiedYearOfBirth = GetRandomString();
        person.setCertifiedYearOfBirth(certifiedYearOfBirth);
        assertEquals(certifiedYearOfBirth, person.getCertifiedYearOfBirth());
    }


}